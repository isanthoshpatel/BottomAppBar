package com.example.bottomappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Scroller
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ActionProvider
import androidx.core.view.doOnPreDraw
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "you clicked on navigationIcon", Toast.LENGTH_LONG).show()
        }
        bottomAppBar.setOnMenuItemClickListener(this)

    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.save -> {
                var text = sv.query.toString().trim()
                if (text.isEmpty()) {
                    Toast.makeText(this, "Enter search text", Toast.LENGTH_LONG).show()
                    return false
                }
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
                sv.setQuery("", true)
            }
            R.id.search1 -> {
                var s = bottomAppBar.findViewById<SearchView>(R.id.search1)
                var text = s.query.toString()

                if (text.isEmpty()) {
                    Toast.makeText(this, "Enter search text", Toast.LENGTH_LONG).show()
                    return false
                }
                Toast.makeText(this,s.outlineProvider.toString().trim(), Toast.LENGTH_LONG).show()
                s.setQuery("", true)


            }
        }
        return true
    }
}
