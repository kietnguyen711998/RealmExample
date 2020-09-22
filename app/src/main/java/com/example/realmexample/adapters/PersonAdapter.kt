package com.example.realmexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realmexample.R
import com.example.realmexample.model.Person
import io.realm.RealmResults
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter(private val context: Context, val personlist: RealmResults<Person>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return personlist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.item_id.text = personlist[position]!!.mId.toString()
        holder.itemView.txtName.text = personlist[position]!!.mName
        holder.itemView.txtAge.text = personlist[position]!!.mAge
        holder.itemView.txtAddress.text = personlist[position]!!.mAddress
        holder.itemView.txtEmail.text = personlist[position]!!.mEmail
        holder.itemView.txtPhone.text = personlist[position]!!.mPhone

    }

    class ViewHolder(v: View?) : RecyclerView.ViewHolder(v!!) {
        val id = itemView.findViewById<TextView>(R.id.item_id)
        val name = itemView.findViewById<TextView>(R.id.txtName)
        val age = itemView.findViewById<TextView>(R.id.txtAge)
        val address = itemView.findViewById<TextView>(R.id.txtAddress)
        val email = itemView.findViewById<TextView>(R.id.txtEmail)
        val phone = itemView.findViewById<TextView>(R.id.txtPhone)

    }

}