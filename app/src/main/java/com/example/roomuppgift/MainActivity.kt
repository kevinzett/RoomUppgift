package com.example.roomuppgift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.roomuppgift.databinding.ActivityMainBinding
import com.example.roomuppgift.roomdata.Person
import com.example.roomuppgift.roomdata.PersonDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(View.OnClickListener {
            if(!binding.tvFirstName.text.isEmpty() && !binding.tvLastName.text.isEmpty()) {
                val personInformation = Person(null, binding.tvFirstName.text.toString(),
                binding.tvLastName.text.toString())

                GlobalScope.launch (Dispatchers.IO){
                    PersonDatabase.getInstance(this@MainActivity).personDao().insert(personInformation)
                }
                Toast.makeText(applicationContext, "Name Added", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "Insert Values!!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}