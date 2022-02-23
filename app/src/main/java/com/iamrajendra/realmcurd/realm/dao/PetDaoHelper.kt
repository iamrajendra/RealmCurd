package com.iamrajendra.realmcurd.realm.dao

import android.R.id
import com.iamrajendra.realmcurd.realm.model.Pet
import com.iamrajendra.realmcurd.realm.schema.RealmPet
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class PetDaoHelper  @Inject constructor(private val config: RealmConfiguration)
{

    suspend fun insert(name: String, age: Int, type: String, image: Int?) {
        val realm = Realm.getInstance(config)

        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            val pet = RealmPet(name = name, age = age, petType = type, image = image)
            realmTransaction.insert(pet)
        }
    }


    suspend fun fetchAll(): List<Pet> {
        val realm = Realm.getInstance(config)
        val adoptedPets = mutableListOf<Pet>()

        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            adoptedPets.addAll(realmTransaction
                .where(RealmPet::class.java)
                .findAll()
                .map {
                    mapPet(it)
                }
            )
        }
        return adoptedPets
    }

    suspend fun deleteById(petId: String) {
        val realm = Realm.getInstance(config)
        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            val petToRemove = realmTransaction
                .where(RealmPet::class.java)
                .equalTo("id", petId)
                .findFirst()
            petToRemove?.deleteFromRealm()
        }
    }
  suspend fun fetchById(id:String):Pet {
      var realm = Realm.getInstance(config)
     var realmPet = realm.where(RealmPet::class.java).equalTo("id",id).findFirst()
       return mapPet(realmPet!!)
  }
  suspend fun updateNameById(id: String,name: String){
      var realm  = Realm.getInstance(config)
     var pet = realm.where(RealmPet::class.java).equalTo("id",id).findFirst();
      pet?.name = name;
      realm.insertOrUpdate(pet)
  }

  }
    private fun mapPet(pet: RealmPet): Pet {
        return Pet(
            name = pet.name,
            age = pet.age,
            image = pet.image,
            petType = pet.petType,
            isAdapted = pet.isAdopted,
            id = pet.id,
        )
    }
