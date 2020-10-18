package com.example.lab9mysqlupdatedelete

import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.edit_delete_item_layout.view.*
import java.lang.reflect.Type

class EditStudentsAdapter (val items : List<Student>, val context: Context):RecyclerView.Adapter<EditStudentsAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val  tvID :TextView = view.tvID
        val tvName : TextView = view.tvName

    }

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ViewHolder{
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.edit_delete_item_layout,parent,false)
        val myHolder = ViewHolder(view_item)

        view_item.setOnClickListener(){
            val pos  = myHolder.adapterPosition
            val context = parent.context
            val  student = items[pos]
            val  intent = Intent(context,EditDeleteActivity::class.java)
            intent.putExtra("mId",student.std_id)
            intent.putExtra("mName",student.std_name)
            intent.putExtra("mAge",student.std_age.toString())
            context.startActivity(intent)

        }
        return myHolder
    }


    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.tvID.text = items[position].std_id
        holder.tvName.text = items[position].std_name
    }

    override fun getItemCount(): Int {
        return items.size
    }
}