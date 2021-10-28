package com.frontier.infinitescrollrecyclerview.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frontier.infinitescrollrecyclerview.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridHorizontalAction.setOnClickListener {
            startActivity(Intent(this, GridHorizontalAutoScrollActivity::class.java))
        }
        listHorizontalAction.setOnClickListener {
            startActivity(Intent(this, ListHorizontalAutoScrollActivity::class.java))
        }
    }
}