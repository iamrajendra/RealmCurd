package com.iamrajendra.realmcurd.di.component

import com.iamrajendra.App
import com.iamrajendra.realmcurd.di.module.RealmModule
import com.iamrajendra.realmcurd.di.scope.MainActivityScope
import com.iamrajendra.realmcurd.ui.MainActivity
import dagger.Component
@MainActivityScope
@Component(
    modules = [
        RealmModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}