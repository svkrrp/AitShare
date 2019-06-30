package com.example.aitshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.test.espresso.idling.CountingIdlingResource
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    val countingIdlingResource = CountingIdlingResource("data_loaded")
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseDatabase.getInstance().reference.child("user")

        login.setOnClickListener {
            validate(id.text.toString(), password.text.toString())
        }

        signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validate(id: String, password: String) {
        countingIdlingResource.increment()
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(id.equals(dataSnapshot.child("id").getValue(String::class.java)) && password.equals(dataSnapshot.child("password").getValue(String::class.java))){
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                    countingIdlingResource.decrement()
                }else{
                    Toast.makeText(parent, "error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.v("Error : ", "loadPost:onCancelled")
            }
        }
        database.child(id).addValueEventListener(postListener)
    }
}
