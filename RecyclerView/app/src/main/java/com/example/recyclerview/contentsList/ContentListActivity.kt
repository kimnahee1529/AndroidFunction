package com.example.recyclerview.contentsList

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
//import com.example.recyclerview.databinding.ActivityContentListBinding

class ContentListActivity : AppCompatActivity() {

//    private lateinit var binding : ActivityContentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        val rv : RecyclerView = findViewById(R.id.rv)

        val items = ArrayList<String>()
        items.add("a")
        items.add("b")
        items.add("c")
        items.add("c")
        items.add("c")
        items.add("c")

        val rvAdapter = ContentRVAdapter(items)
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this,2)


    }
}