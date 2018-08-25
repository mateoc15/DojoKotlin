package com.example.mateocanob.dojok

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.example.mateocanob.dojok.Database.DBhelper
import com.example.mateocanob.dojok.Model.Note

import kotlinx.android.synthetic.main.activity_new_note.*

class NewNote : AppCompatActivity() {
    private var database : DBhelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        guardar.setOnClickListener(){
            val title = titulo.text.toString()
            val body = texto.text.toString()

            var note = Note(title, body)
            database = DBhelper(this)
            database!!.insertNote(note)

            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
        salir.setOnClickListener(){
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
    }

}
