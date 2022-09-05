package com.example.deliveryshareapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class PostDetailWriterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail_writer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.post_detail_writer_overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.action_edit -> { return true }
            //R.id.action_delete -> { return stopBtn() }
            //R.id.action_report -> { return palyBtn() }
            else -> {return super.onOptionsItemSelected(item)}
        }
    }
}