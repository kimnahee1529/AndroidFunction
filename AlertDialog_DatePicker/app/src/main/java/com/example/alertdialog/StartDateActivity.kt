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
import java.util.*

class StartDateActivity : AppCompatActivity(), View.OnClickListener {

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

        val textView = findViewById<TextView>(R.id.textView)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)

        val endDate = intent.getStringExtra("MaintoEndDate")

//        Log.d("TAGGGGG", "Main에서 가져온 startdate의 값 : " + a.toString())
//        Log.d("TAGGGGG", "Main에서 가져온 enddate의 값 : " + b.toString())

        textView.text = datePicker.year.toString() + "/" +
                (datePicker.month + 1).toString() + "/" + datePicker.dayOfMonth.toString()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("JudgetoMain", "StarttoMain")
        intent.putExtra("StartDatetoMain", textView.text.toString())
        intent.putExtra("EndDatetoMain", endDate.toString())
        startActivity(intent)

    }
}