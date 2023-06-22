package com.example.alertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val startDate  = findViewById<TextView>(R.id.startDate)
        val endDate = findViewById<TextView>(R.id.endDate)

        // mainBtn을 누르고 StartDate값을 입력받음
        binding.mainBtn.setOnClickListener {
            val intent = Intent(this, StartDateActivity::class.java)
            // StartDate값은 입력받아야 하니 EndDate값만 보냄
            intent.putExtra("MaintoEndDate", endDate.text.toString())
            startActivity(intent)
        }

        // mainBtn2을 누르고 EndDate값을 입력받음
        binding.mainBtn2.setOnClickListener {
            val intent = Intent(this, EndDateActivity::class.java)
            // EndDate값은 입력받아야 하니 StartDate값만 보냄
            intent.putExtra("MaintoStartDate", startDate.text.toString())
            startActivity(intent)
        }


        // EndDateActivity에서 보낸 값을 화면에 표시
        if (intent.getStringExtra("JudgetoMain") == "EndtoMain"){
            val a = intent.getStringExtra("StartDatetoMain")
            val b = intent.getStringExtra("EndDatetoMain")
//            Log.d("TAGGGGG", "end에서 가져온 startdate의 값 : " + a.toString())
//            Log.d("TAGGGGG", "end에서 가져온 enddate의 값 : " + b.toString())
            startDate.text = a
            endDate.text = b
        }
        // StartDateActivity에서 보낸 값을 화면에 표시
        else if (intent.getStringExtra("JudgetoMain") == "StarttoMain"){
            val a = intent.getStringExtra("StartDatetoMain")
            val b = intent.getStringExtra("EndDatetoMain")
//            Log.d("TAGGGGG", "start에서 가져온 startdate의 값 : " + a.toString())
//            Log.d("TAGGGGG", "start에서 가져온 enddate의 값 : " + b.toString())
            startDate.text = a
            endDate.text = b
        }

    }

}