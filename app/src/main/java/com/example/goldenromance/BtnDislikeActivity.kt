package com.example.goldenromance

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.goldenromance.TopNavigationViewHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class BtnDisLikeActivity : AppCompatActivity() {

    private val TAG = "BtnDisLikeActivity"
    private val ACTIVITY_NUM = 1
    private lateinit var mContext: Context
    private lateinit var dislike: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btn_dislike)

        mContext = this
        setupTopNavigationView()
        dislike = findViewById(R.id.dislike)

        val intent = intent
        val profileUrl = intent.getStringExtra("url")

        when (profileUrl) {
            "default" -> Glide.with(mContext).load(R.drawable.profile).into(dislike)
            else -> Glide.with(mContext).load(profileUrl).into(dislike)
        }

        Thread {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val mainIntent = Intent(this@BtnDisLikeActivity, MainActivity::class.java)
            startActivity(mainIntent)
        }.start()
    }

    private fun setupTopNavigationView() {
        val tvEx = findViewById<BottomNavigationView>(R.id.topNavigationViewBar)
        TopNavigationViewHelper.setupTopNavigationView(tvEx)
        TopNavigationViewHelper.enableNavigation(mContext, tvEx)
        val menu: Menu = tvEx.menu
        val menuItem: MenuItem = menu.getItem(ACTIVITY_NUM)
        menuItem.isChecked = true
    }

    fun DislikeBtn(view: View) {

    }
}