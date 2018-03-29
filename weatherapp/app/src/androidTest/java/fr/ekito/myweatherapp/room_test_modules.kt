//package fr.ekito.myweatherapp
//
//import android.arch.persistence.room.Room
//import fr.ekito.myweatherapp.data.datasource.room.WeatherDatabase
//import org.koin.dsl.module.applicationContext
//
//// Room In memroy database
//val roomTestModule = applicationContext {
//    bean {
//        Room.inMemoryDatabaseBuilder(get(), WeatherDatabase::class.java)
//            .allowMainThreadQueries()
//            .build()
//    }
//}