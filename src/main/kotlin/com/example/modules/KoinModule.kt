package com.example.modules

import com.example.repository.HeroRepository
import com.example.repository.interfaces.IHeroRepository
import org.koin.dsl.module

val KoinModule = module {
    single<IHeroRepository> {
        HeroRepository()
    }
}