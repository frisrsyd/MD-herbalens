package com.dicoding.md_herbalens.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dicoding.md_herbalens.R
import com.dicoding.md_herbalens.model.Taxonomy

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    title: String,
    image: String,
    description: String,
    benefits: List<String>,
    recipes: List<String>,
    taxonomy: Taxonomy,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxHeight(1f)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Spacer(modifier = modifier.padding(top = 40.dp))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.padding(top = 28.dp))
            AsyncImage(
                model = image,
                contentDescription = "image of $title",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(168.dp)
            )
            Spacer(modifier = modifier.padding(top = 28.dp))
            //taxonomy
            Text(
                text = "Taksonomi",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = modifier.padding(top = 8.dp))
            Text(
                text = "Kingdom: ${taxonomy.kingdom}",
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 8.dp))

            Text(
                text = "Division: ${taxonomy.division}",
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 8.dp))

            Text(
                text = "Class: ${taxonomy.classis}",
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 8.dp))

            Text(
                text = "Order: ${taxonomy.ordo}",
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 8.dp))

            Text(
                text = "Family: ${taxonomy.family}",
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 8.dp))

            Text(
                text = "Genus: ${taxonomy.genus}",
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 8.dp))

            Text(
                text = "Species: ${taxonomy.species}",
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 28.dp))
            Text(
                text = description,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = modifier.padding(top = 20.dp))
            Text(
                text = "Manfaat",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = modifier.padding(top = 8.dp))
            benefits.forEach {
                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_lens_24),
                        contentDescription = "List Icon",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = modifier
                            .padding(top = 4.dp)
                            .size(8.dp)
                    )
                    Spacer(modifier = modifier.padding(end = 4.dp))
                    Text(
                        text = it,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Justify
                    )
                }
                Spacer(modifier = modifier.padding(top = 12.dp))
            }
            Spacer(modifier = modifier.padding(top = 16.dp))
            Text(
                text = "Resep",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = modifier.padding(top = 8.dp))
            recipes.forEach {
                Row(
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_lens_24),
                        contentDescription = "List Icon",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = modifier
                            .padding(top = 4.dp)
                            .size(8.dp)
                    )
                    Spacer(modifier = modifier.padding(end = 4.dp))
                    Text(
                        text = it,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Justify
                    )
                }
                Spacer(modifier = modifier.padding(top = 12.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailContentPreview() {
    DetailContent(
        title = "Daun Sirsak",
        image = "https://storage.googleapis.com/datasetherbalens/shown_images/alang-alang.jpg",
        taxonomy = Taxonomy(
            kingdom = "Plantae",
            division = "Tracheophyta",
            classis = "Liliopsida",
            ordo = "Poales",
            family = "Poaceae",
            genus = "Imperata",
            species = "Imperata cylindrica"
        ),
        description = "Daun sirsak adalah daun dari pohon sirsak yang biasa tumbuh di daerah tropis. Daun sirsak memiliki banyak manfaat untuk kesehatan, salah satunya adalah untuk mengobati kanker. Daun sirsak mengandung senyawa acetogenins yang dapat membunuh sel kanker. Selain itu, daun sirsak juga mengandung senyawa lain yang dapat menghambat pertumbuhan sel kanker. Daun sirsak juga mengandung senyawa antioksidan yang dapat melawan radikal bebas dan mencegah kerusakan sel. Daun sirsak juga mengandung senyawa antiinflamasi yang dapat mengurangi peradangan. Daun sirsak juga mengandung senyawa antidiabetes yang dapat mengurangi kadar gula darah. Daun sirsak juga mengandung senyawa antikolesterol yang dapat mengurangi kadar kolesterol. Daun sirsak juga mengandung senyawa antijamur yang dapat mengobati infeksi jamur. Daun sirsak juga mengandung senyawa antiparasit yang dapat mengobati infeksi parasit. Daun sirsak juga mengandung senyawa antiradang yang dapat mengurangi peradangan.",
        benefits = listOf(
            "Mengobati kanker",
            "Mengobati diabetes",
            "Mengobati kolesterol",
            "Mengobati infeksi jamur",
            "Mengobati infeksi parasit",
            "Mengurangi peradangan"
        ),
        recipes = listOf(
            "Daun sirsak",
            "Air",
            "Gula",
            "Jeruk nipis",
            "Jahe",
            "Kayu manis",
            "Cengkeh",
            "Kunyit",
            "Kemangi",
            "Kunyit",
            "Kemangi",
            "Kunyit",
            "Kemangi",
            "Kunyit",

            ),
        onBackClick = {}
    )
}