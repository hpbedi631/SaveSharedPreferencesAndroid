package com.example.savesharedpreferencesdemo

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getPreferences(Context.MODE_PRIVATE)
        val name = pref.getString("NAME", "")
        val id = pref.getInt("ID", 0)
        editName.setText(name)
        editID.setText(id.toString())
    }

    // create a shared preferences file
    // and save name and ID values as values/pairs in file

    fun OnSave(view: View) {
// create shared preferences file
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        // save name
        editor.putString("NAME", editName.text.toString())
        // save ID
        editor.putInt("ID", editID.text.toString().toInt())
        // commit changes
        editor.commit()

        val toast = Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 140)
        toast.show()


    }

    fun onClear(view: View) {
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()

        editName.setText("")
        editID.setText("0")
    }
}
