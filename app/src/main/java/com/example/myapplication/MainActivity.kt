package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var rctid:Rocketplay
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rctid=findViewById<Rocketplay>(R.id.playarea)

    }
    fun start(view:View) {

    }


    fun end(view: View)
    {

    }
}