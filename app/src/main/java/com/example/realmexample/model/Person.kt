package com.example.realmexample.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Person(
    @PrimaryKey

    var mId: Int = 0,
    var mName: String? = null,
    var mAge: String? = null,
    var mAddress: String? = null,
    var mPhone: String? = null,
    var mEmail: String? = null
): RealmObject()