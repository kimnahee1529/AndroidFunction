package com.example.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.inflate
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.alertdialog.databinding.ActivityMainBinding
import com.example.alertdialog.databinding.ActivityMainBinding.inflate
import com.example.alertdialog.databinding.CustomDialogBinding.inflate

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.mainBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
            val dialogText = dialogView.findViewById<EditText>(R.id.dialogEt)
            val dialogRatingBar = dialogView.findViewById<RatingBar>(R.id.dialogRb)

            builder.setView(dialogView)
                .setPositiveButton("확인") { dialogInterface, i ->
                    Log.d("TAG",dialogText.text.toString())
                    Log.d("TAG", dialogRatingBar.rating.toString())
                    binding.mainTv.text=dialogText.text.toString()
                    binding.mainRb.rating=dialogRatingBar.rating
                    /* 확인일 때 main의 View의 값에 dialog View에 있는 값을 적용 */

                }
                .setNegativeButton("취소") { dialogInterface, i ->
                    /* 취소일 때 아무 액션이 없으므로 빈칸 */
                }
                .show()
        }
    }
}