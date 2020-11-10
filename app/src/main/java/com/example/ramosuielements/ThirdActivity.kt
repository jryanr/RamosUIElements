package com.example.ramosuielements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val intent = intent
        val firstName_et = intent.getStringExtra("firstName_et")
        val lastName_et = intent.getStringExtra("lastName_et")
        val age = intent.getIntExtra("age", 0).toString()
        val birthday = intent.getStringExtra("birthday")
        val email_et = intent.getStringExtra("email_et")
        val phone_et = intent.getStringExtra("phone_et")

        //textview
        val info_et = findViewById<TextView>(R.id.info_et)
        //setText
        info_et.text = "First Name: "+firstName_et+"\n"+"\n"+
                "Last Name: "+lastName_et+"\n"+"\n"+
                "Age: "+age+"\n"+"\n"+birthday+"\n"+"\n"+
                "Email: "+email_et+"\n"+"\n"+
                "Phone Number: "+phone_et

    }
}