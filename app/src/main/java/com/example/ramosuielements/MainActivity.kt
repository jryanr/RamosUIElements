package com.example.ramosuielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var passedAge = 0
        val seek = findViewById<SeekBar>(R.id.age_sb)
            seek?.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var min = 18
                var max = 60
                findViewById<SeekBar>(R.id.age_sb).setMax(max-min)
                val progress_custom = min + (progress)
                findViewById<TextView>(R.id.age_txt).text = "Age: " + progress_custom.toString()
                passedAge = min + progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        findViewById<Switch>(R.id.phone_sw).setOnClickListener{showField()}
        findViewById<Button>(R.id.nextPage_btn).setOnClickListener{nextPage(passedAge)}
    }

    private fun showField(){
        if (findViewById<Switch>(R.id.phone_sw).isChecked() == true){
            findViewById<EditText>(R.id.phone_et).setVisibility(View.VISIBLE)
        }
        else if(findViewById<Switch>(R.id.phone_sw).isChecked() == false){
            findViewById<EditText>(R.id.phone_et).setVisibility(View.INVISIBLE)
        }

    }

    private fun nextPage(passedAge: Int){
        val firstName_et = findViewById<EditText>(R.id.firstName_et).text.toString()
        val lastName_et = findViewById<EditText>(R.id.lastName_et).text.toString()
        val email_et = findViewById<EditText>(R.id.email_et).text.toString()
        var phone_et = findViewById<EditText>(R.id.phone_et).text.toString()
        val age = passedAge

        if (phone_et.isBlank()){
            phone_et = "No Input"
        }

        val intent = Intent(this, OtherActivity::class.java)
        intent.putExtra("firstName_et", firstName_et)
        intent.putExtra("lastName_et", lastName_et)
        intent.putExtra("email_et", email_et)
        intent.putExtra("phone_et", phone_et)
        intent.putExtra("age", age)
        startActivity(intent)
    }


}