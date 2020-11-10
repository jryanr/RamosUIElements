package com.example.ramosuielements

import android.content.Intent
import android.os.Bundle
import android.widget.*
import android.widget.CalendarView.OnDateChangeListener
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

var birthday = "01/01/1998"
class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        val selectedDate = "01/01/1998"
        findViewById<CalendarView>(R.id.calendarView).setDate(SimpleDateFormat("dd/MM/yyyy").parse(selectedDate).getTime(), true, true)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            val default = "Birthday: "
            birthday = default + (month + 1) + "/" + dayOfMonth + "/" + year
        }

        findViewById<Button>(R.id.complete_btn).setOnClickListener{complete()}
    }

    private fun complete(){
        val firstName_et = intent.getStringExtra("firstName_et")
        val lastName_et = intent.getStringExtra("lastName_et")
        val email_et = intent.getStringExtra("email_et")
        val phone_et = intent.getStringExtra("phone_et")
        val age = intent.getIntExtra("age", 0)

        val intent = Intent(this@OtherActivity, ThirdActivity::class.java)
        intent.putExtra("firstName_et", firstName_et)
        intent.putExtra("lastName_et", lastName_et)
        intent.putExtra("email_et", email_et)
        intent.putExtra("phone_et", phone_et)
        intent.putExtra("age", age)
        intent.putExtra("birthday", birthday)
        startActivity(intent)

    }

}

