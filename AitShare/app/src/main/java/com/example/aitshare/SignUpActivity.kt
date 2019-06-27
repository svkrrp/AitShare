package com.example.aitshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        database = FirebaseDatabase.getInstance().reference

        signup.setOnClickListener {
            val user = User(username.text.toString(), password.text.toString(), year.text.toString(), id.text.toString())
            database.child("user").child(id.text.toString()).setValue(user)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
