package com.iamrajendra

import android.app.Application
import com.iamrajendra.realmcurd.di.module.RealmModule
import io.realm.Realm

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(baseContext)

    }

}