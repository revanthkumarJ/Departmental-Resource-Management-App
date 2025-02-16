package com.example.departmentalresourcemanagement.features.crprofiles.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.R
import com.example.departmentalresourcemanagement.core.openings.openDialPad
import com.example.departmentalresourcemanagement.core.openings.openGmail
import com.example.departmentalresourcemanagement.core.openings.openUrlInBrowser
import com.example.departmentalresourcemanagement.core.openings.openWhatsApp


@Composable
fun CrProfileCard(
    image:Int,
    name: String,
    section: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .width(300.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(text = name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)

            Text(text = section, style = MaterialTheme.typography.bodySmall)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {

                Image(
                    painter = painterResource(id = R.drawable.mobile),
                    contentDescription = "Phone",
                    modifier = Modifier.size(28.dp).clickable{
                        openDialPad(context,"9949943651")
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.gmail),
                    contentDescription = "Gmail",
                    modifier = Modifier.size(28.dp).clickable{
                        openGmail(context,"jrevanth101@gmail.com")
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "LinkdeIn",
                    modifier = Modifier.size(28.dp).clickable{
                        openUrlInBrowser(context,"https://www.linkedin.com/in/jilakararevanthkumar/")
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "Github",
                    modifier = Modifier.size(28.dp).clickable{
                        openUrlInBrowser(context,"https://github.com/revanthkumarJ")
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.whatsapp),
                    contentDescription = "Whatsapp",
                    modifier = Modifier.size(28.dp).clickable {
                        openWhatsApp(context, "9949943651")
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CrProfileCardPreview() {
    CrProfileCard(
        image = R.drawable.placeholder,
        section = "E3 Section B",
        name = "J. Revanth Kumar",
    )
}

