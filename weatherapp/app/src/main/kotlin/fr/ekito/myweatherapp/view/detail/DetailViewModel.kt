package fr.ekito.myweatherapp.view.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import fr.ekito.myweatherapp.domain.entity.DailyForecast
import fr.ekito.myweatherapp.domain.repository.DailyForecastRepository
import fr.ekito.myweatherapp.util.mvvm.RxViewModel
import fr.ekito.myweatherapp.util.rx.SchedulerProvider
import fr.ekito.myweatherapp.util.rx.with
import fr.ekito.myweatherapp.view.Failed
import fr.ekito.myweatherapp.view.Loading
import fr.ekito.myweatherapp.view.ViewModelState

class DetailViewModel : RxViewModel() {

    /*
     * Dependencies out of constructor. Will be filled later by DetailActivity
     */
    lateinit var dailyForecastRepository: DailyForecastRepository
    lateinit var schedulerProvider: SchedulerProvider

    private val _states = MutableLiveData<ViewModelState>()
    val states: LiveData<ViewModelState>
        get() = _states

    fun getDetail(id: String) {
        _states.value = Loading
        launch {
            dailyForecastRepository.getWeatherDetail(id).with(schedulerProvider).subscribe(
                { detail ->
                    _states.value = DetailLoaded(detail)
                },
                { error ->
                    _states.value = Failed(error)
                })
        }
    }

    data class DetailLoaded(val weather: DailyForecast) : ViewModelState()
}