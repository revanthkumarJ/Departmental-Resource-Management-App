package com.example.departmentalresourcemanagement.features

import android.app.Activity
import android.content.IntentSender
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.R
import com.example.departmentalresourcemanagement.features.home.ui.components.HomeTopBar
import com.example.departmentalresourcemanagement.features.home.ui.screens.Home
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import kotlinx.coroutines.launch

@Composable
fun GoogleSignInScreen(onSignInSuccess: () -> Unit) {
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()
    val signInClient = Identity.getSignInClient(context)

    var showSignInRequest by remember { mutableStateOf(false) }

    val signInLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = signInClient.getSignInCredentialFromIntent(result.data)
                val googleCredential = task.googleIdToken
                googleCredential?.let {
                    val credential = GoogleAuthProvider.getCredential(it, null)
                    auth.signInWithCredential(credential)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("GoogleAuth", "Sign-in successful")
                                showSignInRequest = false
                                onSignInSuccess()
                            } else {
                                Log.e("GoogleAuth", "Sign-in failed", task.exception)
                            }
                        }
                }
            }
        }

    Scaffold(
        topBar = {

        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(250.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Welcome to Departmental Resource Management",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Sign in to continue",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedButton(
                onClick = { showSignInRequest = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Sign in with Google",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }

        if (showSignInRequest) {
            val signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(
                    BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        .setServerClientId("2163501123-m51kinarjoe6g3aamk27otbsvga9698k.apps.googleusercontent.com") // Replace with your actual client ID from Firebase
                        .setFilterByAuthorizedAccounts(false)
                        .build()
                )
                .build()

            signInClient.beginSignIn(signInRequest)
                .addOnSuccessListener { result ->
                    try {
                        signInLauncher.launch(
                            IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                        )
                    } catch (e: IntentSender.SendIntentException) {
                        Log.e("GoogleAuth", "Couldn't start sign-in intent", e)
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("GoogleAuth", "Sign-in failed", e)
                }
        }
    }
}
