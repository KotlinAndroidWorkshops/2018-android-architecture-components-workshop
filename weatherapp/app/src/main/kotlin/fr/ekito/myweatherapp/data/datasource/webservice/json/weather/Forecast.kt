package fr.ekito.myweatherapp.data.repository.json.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Forecast {

    /**
     * @return The txtForecast
     */
    /**
     * @param txtForecast The txt_forecast
     */
    @SerializedName("txtForecast")
    @Expose
    var txtForecast: TxtForecast? = null
    /**
     * @return The simpleforecast
     */
    /**
     * @param simpleforecast The simpleforecast
     */
    @Expose
    var simpleforecast: Simpleforecast? = null

}
