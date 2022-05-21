package com.example.email

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button) as Button

        btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("Email")
            val str_array = arrayOf("test@gmail.com","test2@gmail.com","test3@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL,str_array)
            intent.putExtra(Intent.EXTRA_SUBJECT,"This field is for subject")
            intent.putExtra(Intent.EXTRA_TEXT,"This is field is for Email body")
            intent.type = "message/rfc822"
            val a = Intent.createChooser(intent,"Launch Email")
            startActivity(a)
        }
    }
}