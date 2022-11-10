package com.example.backgroundservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClickListener()
    }

    private fun initClickListener(){
        val button: Button = findViewById(R.id.startServiceButton)
        val name: TextView = findViewById(R.id.name)
        val email: TextView = findViewById(R.id.email)
        val id: TextView = findViewById(R.id.id)

        button.setOnClickListener {
            if(name.text.isNotEmpty() && email.text.isNotEmpty() && id.text.isNotEmpty()){
                val intent = Intent(applicationContext, MyBackgroundService::class.java).apply {
                    putExtra("name", name.text.toString())
                    putExtra("email", email.text.toString())
                    putExtra("id", id.text.toString())
                    type ="text/plain"
                }
                startService(intent)
            }else {
                Toast.makeText(this, "Fill out all the required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
