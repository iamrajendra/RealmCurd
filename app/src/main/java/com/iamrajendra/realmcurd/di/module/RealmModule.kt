package com.iamrajendra.realmcurd.di.module

import com.iamrajendra.realmcurd.realm.dao.PetDao
import com.iamrajendra.realmcurd.realm.dao.PetDaoHelper
import com.iamrajendra.realmcurd.realm.dao.PetDaoImpl
import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
class RealmModule {


    private val realmVersion = 1L

    @Provides
    fun providesRealmConfig(): RealmConfiguration =
        // 2.
        RealmConfiguration.Builder()
            .schemaVersion(realmVersion)
            .build()


    @Provides
    fun providePetDao(configuration: RealmConfiguration): PetDao {
        return PetDaoImpl(PetDaoHelper(configuration))
    }

}