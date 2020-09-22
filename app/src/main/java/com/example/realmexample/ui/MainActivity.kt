package com.example.realmexample.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.realmexample.R
import com.example.realmexample.adapters.PersonAdapter
import com.example.realmexample.model.Person
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var personlist: ArrayList<Person>
    lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        btn_add.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
            finish()
        }
        personRV.layoutManager = LinearLayoutManager(this)

        getAllPersons()
    }

    private fun getAllPersons() {
        personlist = ArrayList()

        val result = realm.where(Person::class.java).findAll()
        personRV.adapter = PersonAdapter(this, result)
        personRV.adapter!!.notifyDataSetChanged()
    }
}