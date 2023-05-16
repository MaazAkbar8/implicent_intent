package com.example.implicentintent

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DownloadManager.Request
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var iv: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv = findViewById<ImageView>(R.id.iv)
        val Button = findViewById<Button>(R.id.button)

        Button.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "Image/*"
                //image/* png,jpg,jpeg all type allow this symbol through
                startActivityForResult(it, 0)
            }
        }
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)//no used default

        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val uri = data?.data
            iv.setImageURI(uri)

        }

    }
    }


