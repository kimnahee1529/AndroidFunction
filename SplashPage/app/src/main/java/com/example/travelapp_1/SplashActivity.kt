package com.example.travelapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.travelapp_1.auth.IntroActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solash)

//        Splash 화면이 뜨고 3초의 딜레이 후 IntroActivity로 이동
         Handler().postDelayed({
             startActivity(Intent(this, IntroActivity::class.java))
             finish()
         }, 3000)
    }
}