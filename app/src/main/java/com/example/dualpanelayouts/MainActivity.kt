package com.example.dualpanelayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

interface StarSignListener{
    fun onSelected(id:Int)
}

const val STAR_SIGN_ID = "STAR_SIGN_ID"

class MainActivity : AppCompatActivity() , StarSignListener{

    var isDualPanel: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isDualPanel = findViewById<View>(R.id.starSignDetail) != null

    }

    override fun onSelected(id: Int) {
        if (isDualPanel){
            val detailFragment = supportFragmentManager.findFragmentById(R.id.starSignDetail) as DetailFragment

            detailFragment.setStartSignData(id)
        }else{
            val detailIntent = Intent(this, DetailFragment::class.java).apply {
                putExtra(STAR_SIGN_ID, id)
            }

            startActivity(detailIntent)
        }
    }
}