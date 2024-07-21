package com.example.recycler_view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerContactAdapter internal constructor(
    var context: Context,
    var arrContacts: ArrayList<ContactModel>
) : RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>() {
    private var lastPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false)
        val viewHolder: ViewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgContact.setImageResource(arrContacts[position].img)
        holder.txtName.text = arrContacts[position].name
        holder.txtNumber.text = arrContacts[position].number
        setAnimation(holder.itemView, position)

        holder.llRow.setOnClickListener {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.add_update_layout)
            val position = holder.adapterPosition
            val edtName = dialog.findViewById<EditText>(R.id.etName)
            val edtNumber = dialog.findViewById<EditText>(R.id.etNumber)
            val btnAction = dialog.findViewById<Button>(R.id.btnAction)
            val textTitle = dialog.findViewById<TextView>(R.id.txtTitle)
            textTitle.text = "Update Contact"
            btnAction.text = "Update"

            edtName.setText(arrContacts[position].name)
            edtNumber.setText(arrContacts[position].number)
            btnAction.setOnClickListener {
                var name = ""
                var number = ""
                if (edtName.text.toString() != "") {
                    name = edtName.text.toString()
                } else {
                    Toast.makeText(context, "Name is required", Toast.LENGTH_SHORT).show()
                }
                if (edtNumber.text.toString() != "") {
                    number = edtNumber.text.toString()
                } else {
                    Toast.makeText(context, "Number is required", Toast.LENGTH_SHORT).show()
                }
                arrContacts[position] = ContactModel(name, number)
                notifyItemChanged(position)
                dialog.dismiss()
            }
            dialog.show()
        }

        holder.llRow.setOnLongClickListener {
            val position = holder.adapterPosition
            val builder = AlertDialog.Builder(
                context
            )
            builder.setTitle("Delete Contact")
            builder.setMessage("Are you sure you want to delete this contact?")
            builder.setPositiveButton("Yes") { dialog, which ->
                arrContacts.removeAt(position)
                notifyItemRemoved(position)
            }
                .setNegativeButton("No") { dialog, which -> dialog.dismiss() }
            builder.show()
            true
        }
    }

    override fun getItemCount(): Int {
        return arrContacts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView = itemView.findViewById(R.id.txtName)
        var txtNumber: TextView = itemView.findViewById(R.id.txtNumber)
        var imgContact: ImageView = itemView.findViewById(R.id.imgContact)
        var llRow: LinearLayout = itemView.findViewById(R.id.llRow)
    }

    private fun setAnimation(viewtoAnimate: View, positon: Int) {
        if (positon > lastPosition) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            viewtoAnimate.startAnimation(animation)
            lastPosition = positon
        }
    }
}
