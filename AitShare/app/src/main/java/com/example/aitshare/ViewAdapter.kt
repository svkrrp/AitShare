package com.example.aitshare

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.buy_view.view.*

class ViewAdapter(val mCtx : Context, val list : ArrayList<BookSell>) : RecyclerView.Adapter<ViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.buy_view, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.amount?.text = list.get(position).amount
        holder?.contact?.text = list.get(position).contact
        holder?.username?.text = list.get(position).username
        holder?.itemView.setOnClickListener {
            val intent = Intent(mCtx, InformationActivity::class.java)
            intent.putExtra("info", list.get(position).book_info)
            mCtx.startActivity(intent)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val amount = view.amount
        val username = view.username
        val contact = view.contact
    }
}