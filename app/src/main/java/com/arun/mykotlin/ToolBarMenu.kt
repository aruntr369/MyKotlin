package com.arun.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ToolBarMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar_menu)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAddContact -> Toast.makeText(this,"You Clicked on Add Contact ",Toast.LENGTH_LONG).show()
            R.id.miFavorites -> Toast.makeText(this,"You Clicked on Favorites ",Toast.LENGTH_LONG).show()
            R.id.misettings -> Toast.makeText(this,"You Clicked on Settings ",Toast.LENGTH_LONG).show()
            R.id.miClose -> finish()
            R.id.miFeedback -> Toast.makeText(this,"You Clicked on Feedback ",Toast.LENGTH_LONG).show()
        }
        return true
    }
}