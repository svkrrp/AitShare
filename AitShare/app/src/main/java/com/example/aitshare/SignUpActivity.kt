package com.example.aitshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            if(username.text.toString()!=null && password.text.toString()!=null && year.text.toString()!=null && id.text.toString()!=null){
                val user = User(username.text.toString(), password.text.toString(), year.text.toString(), id.text.toString())
                database.child("user").child(id.text.toString()).setValue(user)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please enter full details",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
