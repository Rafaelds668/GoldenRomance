package com.example.goldenromance

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class TopNavigationViewHelper {
    private val TAG = "TopNavigationViewHelper"

    fun setupTopNavigationView(tv: BottomNavigationView) {
        Log.d(TAG, "setupTopNavigationView: setting up navigationview")
    }

    fun enableNavigation(context: Context, view: BottomNavigationView) {
        view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_profile -> {
                    val i = Intent(context, SettingsActivity::class.java)
                    context.startActivity(i)
                    true
                }
                R.id.ic_matched -> {
                    val i1 = Intent(context, MatchesActivity::class.java)
                    context.startActivity(i1)
                    true
                }
                else -> false
            }
        }
    }
    companion object {
        fun enableNavigation(mContext: Context, tvEx: Any) {

        }

        fun setupTopNavigationView(tvEx: Any) {

        }
    }
}