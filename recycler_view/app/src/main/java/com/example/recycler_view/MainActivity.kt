package com.example.recycler_view

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var arrContact: ArrayList<ContactModel> = ArrayList()
    var btnOpenDialog: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val adapter = RecyclerContactAdapter(this, arrContact)

        btnOpenDialog = findViewById(R.id.btnOpenDialog)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerContact)

        btnOpenDialog?.setOnClickListener(View.OnClickListener {
            val dialog = Dialog(this@MainActivity)
            dialog.setContentView(R.layout.add_update_layout)
            val edtName = dialog.findViewById<EditText>(R.id.etName)
            val edtNumber = dialog.findViewById<EditText>(R.id.etNumber)
            val btnAdd = dialog.findViewById<Button>(R.id.btnAction)
            btnAdd.setOnClickListener {
                var name = ""
                var number = ""
                if (edtName.text.toString() != "") {
                    name = edtName.text.toString()
                } else {
                    Toast.makeText(this@MainActivity, "Name is required", Toast.LENGTH_SHORT).show()
                }
                if (edtNumber.text.toString() != "") {
                    number = edtNumber.text.toString()
                } else {
                    Toast.makeText(this@MainActivity, "Number is required", Toast.LENGTH_SHORT)
                        .show()
                }

                arrContact.add(ContactModel(name, number))
                adapter.notifyItemChanged(arrContact.size - 1)

                recyclerView.scrollToPosition(arrContact.size - 1)
                dialog.dismiss()
            }
            dialog.show()
        })

        recyclerView.layoutManager = LinearLayoutManager(this)

        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane ", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doem", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "Jane Doe", "0987654321"))
        arrContact.add(ContactModel(R.drawable.ic_launcher_background, "John Doe", "1234567890"))



        recyclerView.adapter = adapter
    }
}