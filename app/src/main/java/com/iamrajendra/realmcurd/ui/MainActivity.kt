package com.iamrajendra.realmcurd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iamrajendra.realmcurd.R
import com.iamrajendra.realmcurd.di.component.DaggerAppComponent
import com.iamrajendra.realmcurd.di.module.RealmModule
import com.iamrajendra.realmcurd.realm.dao.PetDao
import com.iamrajendra.realmcurd.realm.dao.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var petDao: PetDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.builder()
            .realmModule(RealmModule())
            .build()
            .inject(this)
// insert the Pet
        CoroutineScope(Dispatchers.IO).launch {
            petDao.insert("Raj", 12, "loin").collect { status ->
                when (status) {
                    Response.Added -> {
                        Log.i("DATA", "DATA IS ADDED")
                    }
                }

            }
        }
// fetch all the pet
//        CoroutineScope(Dispatchers.IO).launch {
//            petDao.fetchAll().collect { status ->
//                when (status) {
//
//                    is Response.Result -> {
//                        Log.i("DATA", "Pet list size"+status.petList.size)
//                    }
//
//                }
//
//            }
//        }
//        delete by id
        /*CoroutineScope(Dispatchers.IO).launch {
            petDao.deleteById("6214aeddc1c646231d08f59c").collect { status ->
                when (status) {

                   is  Response.Deleted ->{

                    }



                }

            }
        }*/



    }
}




