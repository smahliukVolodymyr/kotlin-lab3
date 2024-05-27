package com.example.lab3

import SpaceItemDecoration
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


data class MyItem(val imageResource: Int, val title: String, val description: String)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.addItemDecoration(SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.space_between_items)))
        val dataList = listOf(
            MyItem(R.drawable.no_image_icon, "Title 1", "Description 1") ,
                    MyItem(R.drawable.no_image_icon, "Title 2", "Description 2")
        )
        val adapter = MyAdapter(this, dataList)
        recyclerView.adapter = adapter

        val linearLayout = findViewById<LinearLayout>(R.id.popular_categories_container)
        linearLayout.setOnClickListener { // Код, який виконується при натисканні на LinearLayout

            // Створюємо намір (Intent) для переходу на другу активність
            val intent = Intent(this@MainActivity, SecondActivity::class.java)

            // Запускаємо другу активність
            startActivity(intent)
        }
    }



}