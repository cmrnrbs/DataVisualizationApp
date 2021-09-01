package com.cemreonur.datavisualizationapp

import android.content.res.Resources
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cemreonur.datavisualizationapp.ui.theme.*


@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(bgColor)
            .fillMaxSize()
    ) {

        Column{

            SecondSubContent()
            Spacer(modifier = Modifier.height(40.dp))
            Column(modifier = Modifier.padding(start =36.dp)) {
                Text(
                    text = "Training",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                TrainingItem(
                    trainings = listOf(
                        TrainingData(vl = 12, title = "Repeatitions", isActive = true),
                        TrainingData(vl = 25, title = "Pushups"),
                        TrainingData(vl = 25, title = "Pushups")
                    )
                )
            }
        }
        FirstSubContent()
        Header()


        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 32.dp, end = 16.dp),
            backgroundColor = Color.White
        ) {
            Icon(Icons.Filled.Add,"",modifier = Modifier.size(30.dp))
        }

    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(RoundedCornerShape(bottomStart = 60.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(bottomStart = 60.dp)
            )
            .background(Color.White)
    )
    {
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = iconColor,
                    modifier = Modifier.size(24.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = iconColor,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Statistics",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 36.dp)
            )
        }
    }
}

@Composable
fun FirstSubContent() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .clip(RoundedCornerShape(bottomStart = 60.dp))
            .background(Color.White)
    ) {

        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val lowColoredPoint1 = Offset(0f, height * 0.5f)
        val lowColoredPoint2 = Offset(width * 0.22f, height * 0.6f)
        val lowColoredPoint3 = Offset(width * 0.55f, height * 0.38f)
        val lowColoredPoint4 = Offset(width * 0.92f, height * 0.68f)
        val lowColoredPoint5 = Offset(width * 1.4f, -height.toFloat() / 2f)

        val lowColoredPath = Path().apply {
            moveTo(lowColoredPoint1.x, lowColoredPoint1.y)
            standardQuadFromTo(lowColoredPoint1, lowColoredPoint2)
            standardQuadFromTo(lowColoredPoint2, lowColoredPoint3)
            standardQuadFromTo(lowColoredPoint3, lowColoredPoint4)
            standardQuadFromTo(lowColoredPoint4, lowColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }


        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.7f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.64f)
        val lightPoint3 = Offset(width * 0.25f, height * 0.75f)
        val lightPoint4 = Offset(width * 0.42f, height * 0.65f)
        val lightPoint5 = Offset(width * 0.55f, height * 0.65f)
        val lightPoint6 = Offset(width * 0.9f, height * 0.8f)
        val lightPoint7 = Offset(width * 1.4f, -height.toFloat() / 2f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            standardQuadFromTo(lightPoint5, lightPoint6)
            standardQuadFromTo(lightPoint6, lightPoint7)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = lowColoredPath,
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        f,
                        s
                    )
                )
            )
            drawPath(
                path = lightColoredPath,
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        firstColor,
                        secondColor
                    )
                )
            )
        }

        Column(
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .fillMaxWidth()
                .padding(horizontal = 36.dp)
                .padding(bottom = 40.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "496",
                    fontWeight = FontWeight.Bold,
                    fontSize = 65.sp, color = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "kcal",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.ExtraLight,
                    color = thinTextColor
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Total Calories", fontSize = 15.sp, color = thinSecondColor)
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color.White), contentAlignment = Alignment.Center
                )
                {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = "Person",
                        tint = s,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun SecondSubContent() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(580.dp)
            .clip(RoundedCornerShape(bottomStart = 60.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        f2,
                        s2
                    )
                )
            )
    ) {

        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.8f)
        val lightPoint2 = Offset(width * 0.12f, height * 0.76f)
        val lightPoint3 = Offset(width * 0.45f, height * 0.85f)
        val lightPoint4 = Offset(width * 0.7f, height * 0.7f)
        val lightPoint5 = Offset(width * 1.18f, height * 1f)
        val lightPoint6 = Offset(width * 1.4f, -height.toFloat())

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            standardQuadFromTo(lightPoint5, lightPoint6)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = lightColoredPath,
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        f3,
                        s3
                    )
                )
            )
        }

        Column(
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .fillMaxWidth()
                .padding(horizontal = 36.dp)
                .padding(bottom = 40.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "120",
                    fontWeight = FontWeight.Bold,
                    fontSize = 65.sp, color = Color.White
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "min",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.ExtraLight,
                    color = thinTextThirdColor
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Total Time", fontSize = 15.sp, color = thinTextFourColor)
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = "Timer",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun TrainingItem(trainings: List<TrainingData>) {
  BoxWithConstraints(modifier= Modifier.fillMaxWidth()) {
      val width = constraints.maxWidth
      LazyRow(
          horizontalArrangement = Arrangement.spacedBy(12.dp),
      ) {
          items(trainings.size)
          {
              TrainingCardItem(item = trainings[it],width = (width * 0.37))
          }
      }
  }
}

@Composable
fun TrainingCardItem(item: TrainingData,width:Double) {
    val itemwidth:Int  = (width / Resources.getSystem().displayMetrics.density).toInt()
    Box(
        modifier = Modifier
            .width(itemwidth.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(cardbgColor), contentAlignment = Alignment.Center
    )
    {
        Column(modifier = Modifier) {
            Text(
                text = item.vl.toString(),
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.title,
                    color = cardText
                )
                Spacer(modifier = Modifier.width(4.dp))
                if (item.isActive) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(circleColor)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ComposablePreview() {
    HomeScreen()
}