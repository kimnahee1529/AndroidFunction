package com.example.alertdialog

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import java.util.*

class EndDateActivity : AppCompatActivity(), View.OnClickListener {

//    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView(R.layout.activity_start_date)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this)

    }

//    @SuppressLint("SetTextI18n")
    //Dialog의 Button을 눌렀을 때
    override fun onClick(view: View?) {

        val textView2 = findViewById<TextView>(R.id.textView)
        val datePicker2 = findViewById<DatePicker>(R.id.datePicker)

        val startDate = intent.getStringExtra("MaintoStartDate")

//        Log.d("TAGGGGG", "Main에서 가져온 startdate의 값 : " + a.toString())
//        Log.d("TAGGGGG", "Main에서 가져온 enddate의 값 : " + b.toString())

        textView2.text = datePicker2.year.toString() + "/" +
                (datePicker2.month + 1).toString() + "/" + datePicker2.dayOfMonth.toString()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("JudgetoMain", "EndtoMain")
        intent.putExtra("StartDatetoMain", startDate.toString())
        intent.putExtra("EndDatetoMain", textView2.text.toString())
        startActivity(intent)


    }
}