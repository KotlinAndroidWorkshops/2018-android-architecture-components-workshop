package fr.ekito.myweatherapp.di

import fr.ekito.myweatherapp.domain.repository.DailyForecastRepository
import fr.ekito.myweatherapp.domain.repository.DailyForecastRepositoryImpl
import fr.ekito.myweatherapp.util.rx.ApplicationSchedulerProvider
import fr.ekito.myweatherapp.util.rx.SchedulerProvider
import fr.ekito.myweatherapp.view.splash.SplashViewModel
import fr.ekito.myweatherapp.view.weather.WeatherViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * App Components
 */
val weatherAppModule = module {
    // SplashViewModel for Splash View
    viewModel { SplashViewModel(get(), get()) }

    viewModel { WeatherViewModel(get(), get()) }

    // Presenter for Detail View
//    factory<DetailContract.Presenter> { DetailPresenter(get(), get()) }

    // Weather Data Repository
    single<DailyForecastRepository> { DailyForecastRepositoryImpl(get()) }

    // Rx Schedulers
    single<SchedulerProvider> { ApplicationSchedulerProvider() }
}

// Gather all app modules
val onlineWeatherApp = listOf(weatherAppModule, remoteDataSourceModule)
val offlineWeatherApp = listOf(weatherAppModule, localAndroidDataSourceModule)