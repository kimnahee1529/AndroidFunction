package com.example.recyclerview.contentsList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.recyclerview.R

class ContentRVAdapter(val items : ArrayList<String>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {

    //ViewHolder 객체를 생성하고 초기화
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    //데이터를 가져와 ViewHolder 안의 내용을 채워줌
    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int){
        holder.bindItems(items[position])
//        Log.d("TAG 출력", items.toString())
    }

    //총 데이터의 개수를 반환해줌
   override fun getItemCount(): Int {
        return items.size
    }

    //item에 있는 내용물을 하나하나 연결해줌
    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : String){

        }
    }
}