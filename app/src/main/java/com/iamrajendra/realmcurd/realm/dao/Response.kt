package com.iamrajendra.realmcurd.realm.dao

import com.iamrajendra.realmcurd.realm.model.Pet

sealed class Response {
    object Loading : Response()
    object Added : Response()
    object Deleted : Response()
    object Updated :Response()
    data class Result(val petList: Any) : Response()

}