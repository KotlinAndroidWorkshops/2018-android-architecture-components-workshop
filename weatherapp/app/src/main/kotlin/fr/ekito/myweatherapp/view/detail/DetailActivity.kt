package fr.ekito.myweatherapp.view.detail

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import fr.ekito.myweatherapp.R
import fr.ekito.myweatherapp.domain.DailyForecastModel
import fr.ekito.myweatherapp.domain.getColorFromCode
import fr.ekito.myweatherapp.util.ext.argument
import fr.ekito.myweatherapp.view.IntentArguments.ARG_WEATHER_ITEM_ID
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

/**
 * Weather Detail View
 */
class DetailActivity : AppCompatActivity(), DetailContract.View {

    // Get all needed data
    private val detailId by argument<String>(ARG_WEATHER_ITEM_ID)

    override val presenter: DetailContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter.getDetail(detailId)
    }

    override fun onStart() {
        super.onStart()
        presenter.subscribe(this)
    }

    override fun onStop() {
        presenter.unSubscribe()
        super.onStop()
    }

    override fun showError(error: Throwable) {
        Snackbar.make(weatherItem, getString(R.string.loading_error)+" - $error", Snackbar.LENGTH_LONG).show()
    }

    override fun showDetail(weather: DailyForecastModel) {
        weatherIcon.text = weather.icon
        weatherDay.text = weather.day
        weatherText.text = weather.fullText
        weatherWindText.text = weather.wind.toString()
        weatherTempText.text = weather.temperature.toString()
        weatherHumidityText.text = weather.humidity.toString()
        weatherItem.background.setTint(getColorFromCode(weather))
        // Set back on background click
        weatherItem.setOnClickListener {
            onBackPressed()
        }
    }
}
