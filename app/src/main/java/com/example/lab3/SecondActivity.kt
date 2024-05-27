package com.example.lab3

import ButtonAdapter
import ButtonItem
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
data class ResultItem1(val src: Int, val title: String, val description: String,val price:String);
class ResultItem2(val src: Int, val title: String, val description: String,val price:String,val quantity:Int)
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val recyclerView: RecyclerView = findViewById(R.id.horizontal_recycler_view)
        val buttonList = listOf(
            ButtonItem("Lorem", Color.GRAY, Color.WHITE),
            ButtonItem("Lorem Ipsum", Color.LTGRAY, Color.DKGRAY),
            ButtonItem("Lorem", Color.LTGRAY, Color.DKGRAY),
            ButtonItem("Lorem Ipsum", Color.LTGRAY, Color.DKGRAY)
        )

        val adapter = ButtonAdapter(buttonList)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapter
        }
        val resultsRecyclerView: RecyclerView = findViewById(R.id.results_recycler_view)
        val resultsList = listOf(
            ResultItem2(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$",2),
            ResultItem1(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$"),
            ResultItem1(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$"),
            ResultItem1(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$"),
            ResultItem1(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$"),
            ResultItem1(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$"),
            ResultItem1(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$"),
            ResultItem1(R.drawable.no_image_icon,"Eye Patches","1 pack 60 items","129$")
        )
        val resultsAdapter = ItemAdaptor(resultsList)
        resultsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity, LinearLayoutManager.VERTICAL, false)
            this.adapter = resultsAdapter
        }
    }
}