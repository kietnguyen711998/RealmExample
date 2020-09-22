package com.example.realmexample.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realmexample.R
import com.example.realmexample.model.Person
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.person_item.*

class DetailActivity : AppCompatActivity() {
    lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        realm = Realm.getDefaultInstance()
        btnSave.setOnClickListener {
            saveToDB()
        }
    }

    private fun saveToDB() {
        try {
            realm.beginTransaction()

            val currentIdNumber: Number? = realm.where(Person::class.java).max("mId")
            val nextId: Int

            nextId = if (currentIdNumber == null) {
                1
            } else {
                currentIdNumber.toInt() + 1
            }

            val persons = Person()
            persons.mId = nextId
            persons.mName = edtName.text.toString()
            persons.mAge = edtAge.text.toString()
            persons.mAddress = edtAddress.text.toString()
            persons.mEmail = edtEmail.text.toString()
            persons.mPhone = edtPhone.text.toString()

            realm.copyToRealmOrUpdate(persons)
            realm.commitTransaction()

            Toast.makeText(this, "Person Added Successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Failed : ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}