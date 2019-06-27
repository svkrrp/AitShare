package com.example.aitshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_buy.*

class BuyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)

        first_year.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            intent.putExtra("year","1")
            startActivity(intent)
        }
    }
}
