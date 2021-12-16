package com.polotika.dictionary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.polotika.dictionary.R
import dagger.hilt.android.AndroidEntryPoint
import values.DictionaryTheme


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            DictionaryTheme{

            }
        }
    }
}

