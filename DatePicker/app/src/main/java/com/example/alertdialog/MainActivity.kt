package com.example.alertdialog

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.inflate
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.alertdialog.databinding.ActivityMainBinding
import com.example.alertdialog.databinding.ActivityMainBinding.inflate
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

//    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        val textView2 = findViewById<TextView>(R.id.textView2)
        val button2 = findViewById<Button>(R.id.button2)

        textView.text =
            """
                        초기 설정된 날짜 [년도/월/일]
                        $year/${month+1}/$dayOfMonth
                        """.trimIndent()

        textView2.text =
            """
                        초기 설정된 날짜 [년도/월/일]
                        $year/${month+1}/$dayOfMonth
                        """.trimIndent()

        button.setOnClickListener(this)
        button2.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        val textView = findViewById<TextView>(R.id.textView)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)

        val textView2 = findViewById<TextView>(R.id.textView2)
        val datePicker2 = findViewById<DatePicker>(R.id.datePicker2)

        if(view?.id == R.id.button) {
            textView.text = "출발 날짜 [년도/월/일] : \n" + datePicker.year.toString() + "/" +
                    (datePicker.month + 1).toString() + "/" + datePicker.dayOfMonth.toString()
        }

        if(view?.id == R.id.button2) {
            textView2.text = "도착 날짜 [년도/월/일] : \n" + datePicker2.year.toString() + "/" +
                    (datePicker2.month + 1).toString() + "/" + datePicker2.dayOfMonth.toString()
        }
    }
}