package com.iamrajendra.realmcurd.realm.dao

import kotlinx.coroutines.flow.Flow

interface PetDao  {
    fun insert(name: String, age: Int, type: String, image: Int?=null): Flow<Response>
    fun fetchAll(): Flow<Response>
    fun deleteById( id:String): Flow<Response>
    fun updateNameById(id: String,name: String): Flow<Response>
    fun fetchById(id: String):Flow<Response>

//    fun getAdoptedPets(): Flow<Result>
//
//    fun deletePet(petId: String):Flow<Result>
//
//    fun filterPets(petType: String): Flow<Result>

}



