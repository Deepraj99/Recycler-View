package com.example.recyclerview

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionBtn: FloatingActionButton
    private val list = mutableListOf<ViewModel>()
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = RVAdapter(this, list)
        recyclerView.adapter = adapter

        //Add new item in recycler view
        floatingActionBtn.setOnClickListener{
            val view = layoutInflater.inflate(R.layout.dialog_box, null)
            val dialog = Dialog(this)
            dialog.setContentView(view)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(true)
            dialog.show()

            val btnDone = view.findViewById<Button>(R.id.btn_done)
            btnDone.setOnClickListener{
                val user: EditText = view.findViewById(R.id.et_user)
                val mobile: EditText = view.findViewById(R.id.et_mobile)

                if(user.text.toString() == "")
                    Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show()
                else if(mobile.text.toString() == "")
                    Toast.makeText(this, "Enter mobile", Toast.LENGTH_SHORT).show()

                if(user.text.toString() != ""  &&  mobile.text.toString() != "") {
                    list.add(ViewModel(user.text.toString(), mobile.text.toString()))
                    adapter.notifyItemInserted(list.size-1)
                    recyclerView.scrollToPosition(list.size-1)
                    dialog.dismiss()
                }
            }
        }
    }
    private fun init() {
        recyclerView = findViewById(R.id.recycler_view)
        floatingActionBtn = findViewById(R.id.btn_floating)
        list.add(ViewModel("Deepak", "7266070069"))
        list.add(ViewModel("Anoop", "1234567890"))
        list.add(ViewModel("Deswal", "61393983039"))
        list.add(ViewModel("Johari", "31132132131"))
        list.add(ViewModel("Deepak", "7266070069"))
        list.add(ViewModel("Anoop", "1234567890"))
        list.add(ViewModel("Deswal", "61393983039"))
        list.add(ViewModel("Johari", "31132132131"))
        list.add(ViewModel("Deepak", "7266070069"))
        list.add(ViewModel("Anoop", "1234567890"))
        list.add(ViewModel("Deswal", "61393983039"))
        list.add(ViewModel("Johari", "31132132131"))
        list.add(ViewModel("Deepak", "7266070069"))
        list.add(ViewModel("Anoop", "1234567890"))
        list.add(ViewModel("Deswal", "61393983039"))
        list.add(ViewModel("Johari", "31132132131"))
    }
}