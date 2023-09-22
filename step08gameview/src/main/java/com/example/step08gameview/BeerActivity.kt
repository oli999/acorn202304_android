package com.example.step08gameview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BeerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(BeerView(this))
    }
}