package com.example.drawer1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

//    외부에서 사용하기 위해 전역변수로 변경
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: NavigationView = findViewById(R.id.navigationView)
        drawerLayout = findViewById(R.id.drawerLayout)

        //액션바에 toolbar 셋팅
        setSupportActionBar(findViewById(R.id.toolbar))

        //액션바 객체 생성
        val actionBar: ActionBar? = supportActionBar

        //액션바에 뒤로가기 버튼 생성
        actionBar?.setDisplayHomeAsUpEnabled(true)

        //뒤로가기 버튼 이미지 변경
        actionBar?.setHomeAsUpIndicator(com.google.android.material.R.drawable.ic_clear_black_24)


        //네비게이션뷰 아이템 선택 이벤트
        navigationView.setNavigationItemSelectedListener(
            object: NavigationView.OnNavigationItemSelectedListener{
                override fun onNavigationItemSelected(item: MenuItem): Boolean {

                    when(item.itemId){

                        R.id.nav_camera -> {

                            item.isChecked = true
                            displayMessage("selected camera")
                            drawerLayout.closeDrawers()
                            return true
                        }

                        R.id.nav_photo -> {
                            item.isChecked = true
                            displayMessage("selected photo")
                            drawerLayout.closeDrawers()
                            return true
                        }

                        R.id.nav_slideShow -> {
                            item.isChecked = true
                            displayMessage("selected slideShow")
                            drawerLayout.closeDrawers()
                            return true
                        }

                        else -> {
                            return true
                        }
                    }//when
                }//onNavigationItemSelected
            }//NavigationView.OnNavigationItemSelectedListener
        )//setNavigationItemSelectedListener


    }//onCreate

    //메시지 알림
    private fun displayMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    //옵션메뉴선택 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home ->{

                //drawerLayout 펼치기
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}//MainActivity