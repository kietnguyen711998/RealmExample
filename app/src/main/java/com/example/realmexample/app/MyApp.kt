package com.example.realmexample.app

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("Person.db")
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }
}