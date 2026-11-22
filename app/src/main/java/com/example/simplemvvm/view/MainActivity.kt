package com.example.simplemvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplemvvm.R

// L'Activity només és el contenidor: el NavHostFragment (activity_main.xml)
// s'encarrega de mostrar el Fragment que toqui segons navigation.xml
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
