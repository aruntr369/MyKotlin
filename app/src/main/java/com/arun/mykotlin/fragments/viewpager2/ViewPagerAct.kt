package com.arun.mykotlin.fragments.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.arun.mykotlin.R

class ViewPagerAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val images = listOf(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5)

        val adapter = ViewPagerAdapter(images)
        val viewPager : ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        //for vertical swipe
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        //for fake drag
        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f)
        viewPager.endFakeDrag()

    }

}