package com.example.aitshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sell.*

class SellActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)

        database = FirebaseDatabase.getInstance().reference

        submit.setOnClickListener {
            database.child("sell").child(id.text.toString()).setValue(BookSell(book_year.text.toString(),book_info.text.toString(),amount.text.toString(),id.text.toString(),username.text.toString(),contact.text.toString()))
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
