/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.background
import com.example.androiddevchallenge.ui.theme.buttonRed

@Composable
fun DogDetails(dog: Dog, onAdopt: (Dog) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Box {
            Image(
                painterResource(dog.picture),
                "Dog picture: ${dog.name}",
                Modifier.aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            FloatingActionButton(
                { onAdopt(dog) },
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                backgroundColor = buttonRed
            ) {
                Text(text = stringResource(R.string.plus), style = MaterialTheme.typography.button)
            }
        }
        Column(Modifier.padding(16.dp, 8.dp)) {
            Text(dog.name, style = MaterialTheme.typography.h3)
            ProvideTextStyle(MaterialTheme.typography.h5) {
                Text("Breed: ${dog.breed}")
                Text("Location: ${dog.location}")
                Text("Age: ${dog.age}")
                Text("Gender: ${dog.gender}")
                Text("Size: ${dog.size}")
            }
        }
    }
}

@Preview
@Composable
fun DogDetailsPreview() {
    DogDetails(
        Dog(
            "Momo", "French Bulldog", "French",
            "2", "Female", "Small", R.drawable.img_puppy_momo
        )
    )
}
