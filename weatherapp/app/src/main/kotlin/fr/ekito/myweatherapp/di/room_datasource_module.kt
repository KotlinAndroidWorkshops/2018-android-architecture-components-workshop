package fr.ekito.myweatherapp.di

import android.arch.persistence.room.Room
import fr.ekito.myweatherapp.data.room.WeatherDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val roomDataSourceModule = module {
    // Room Database
    single {
        Room.databaseBuilder(androidApplication(), WeatherDatabase::class.java, "weather-db")
            .build()
    }

    // Expose WeatherDAO
    single { get<WeatherDatabase>().weatherDAO() }
}
