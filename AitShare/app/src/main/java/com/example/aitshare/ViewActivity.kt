package com.example.aitshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.idling.CountingIdlingResource
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    lateinit var viewAdapter: ViewAdapter
    lateinit var list: ArrayList<BookSell>
    val countingIdlingResource = CountingIdlingResource("data_loaded1")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val intent : Intent = intent
        val year : String = intent.getStringExtra("year")

        list = ArrayList<BookSell>()
        countingIdlingResource.increment()
        database = FirebaseDatabase.getInstance().reference
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val elements = dataSnapshot.children.toMutableList()
                for(element in elements){
                    val book_year: String? = element.child("book_year").getValue(String::class.java)
                    if(book_year.equals(year)){
                        val bs : BookSell? = element.getValue(BookSell::class.java)
                        if (bs != null) {
                            list.add(bs)
                        }
                    }
                }
                recyclerView.layoutManager = LinearLayoutManager(this@ViewActivity)
                recyclerView.adapter = ViewAdapter(this@ViewActivity, list)
                countingIdlingResource.decrement()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.v("Error : ", "loadPost:onCancelled")
            }
        }
        database.child("sell").addValueEventListener(postListener)
    }
}
