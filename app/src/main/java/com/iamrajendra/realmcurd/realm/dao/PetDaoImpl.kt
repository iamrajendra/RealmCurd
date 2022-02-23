package com.iamrajendra.realmcurd.realm.dao

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PetDaoImpl @Inject constructor(
    private val databaseOperations: PetDaoHelper
) : PetDao {
    override fun insert(name: String, age: Int, type: String, image: Int?): Flow<Response> = flow<Response> {
        emit(Response.Loading)
        databaseOperations.insert(name, age, type, image)
        emit(Response.Added)

    }.flowOn(Dispatchers.IO)

    override fun fetchAll(): Flow<Response> = flow <Response>{
        emit(Response.Loading)
     var list =   databaseOperations.fetchAll()
        emit(Response.Result(list))
    }.flowOn(Dispatchers.IO)

    override fun deleteById(id: String): Flow<Response> = flow<Response> {
        emit(Response.Loading)
        databaseOperations.deleteById(id)
        emit(Response.Deleted)
    }

    override fun updateNameById(id: String,name: String): Flow<Response>  = flow<Response> {
        emit(Response.Loading)
        databaseOperations.updateNameById(id,name)
        emit(Response.Updated)
    }

    override fun fetchById(id: String): Flow<Response>  = flow {
        emit(Response.Loading)
       var  pet =databaseOperations.fetchById(id);
        emit(Response.Result(pet))
    }

}
