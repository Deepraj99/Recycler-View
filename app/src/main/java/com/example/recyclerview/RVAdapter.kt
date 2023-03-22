package com.example.recyclerview

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class RVAdapter(private val context: Context, private val list: MutableList<ViewModel>) : RecyclerView.Adapter<RVAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val user: TextView = itemView.findViewById(R.id.tv_user)
        val mobile: TextView = itemView.findViewById(R.id.tv_mobile)
        val item: ConstraintLayout = itemView.findViewById(R.id.layout_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("InflateParams", "ResourceType")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.user.text = list[position].user
        holder.mobile.text = list[position].mobile

        //Update an item
        holder.item.setOnClickListener{
            showDialog(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun showDialog(position: Int) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_box)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(true)
        dialog.show()

        val btnDone = dialog.findViewById<Button>(R.id.btn_done)
        val user = dialog.findViewById<EditText>(R.id.et_user)
        val mobile = dialog.findViewById<EditText>(R.id.et_mobile)
        user.setText(list[position].user)
        mobile.setText(list[position].mobile)
        btnDone.setOnClickListener{
            if(user.text.toString() != ""  &&  mobile.text.toString() != "") {
                list[position] = ViewModel(user.text.toString(), mobile.text.toString())
                notifyItemInserted(position)
                dialog.dismiss()
            } else if (user.text.toString() == ""){
                Toast.makeText(context, "Enter user name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Enter mobile", Toast.LENGTH_SHORT).show()
            }
        }
    }
}