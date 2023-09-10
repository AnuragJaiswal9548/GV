package com.example.gv

import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var courseGRV: GridView
    lateinit var courseList: List<GridViewModal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        courseGRV = findViewById(R.id.idGRV)
        courseList = ArrayList<GridViewModal>()

        courseList = courseList + GridViewModal("Google", R.drawable.google)
        courseList = courseList + GridViewModal("Facebook", R.drawable.facebook)
        courseList = courseList + GridViewModal("Twitter", R.drawable.twitter)
        courseList = courseList + GridViewModal("Apple", R.drawable.apple)


        val courseAdapter = GridRVAdapter(courseList = courseList, this@MainActivity)


        courseGRV.adapter = courseAdapter


        courseGRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            Toast.makeText(
                applicationContext, courseList[position].courseName + " selected",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}