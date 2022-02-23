package com.iamrajendra.realmcurd.realm.model

import androidx.annotation.DrawableRes
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

data class Pet (var id:String ="",var name:String ="",var age:Int =-1,var petType:String="",var isAdapted:Boolean=false,var image:Int?=null, var ownerName:String="")


