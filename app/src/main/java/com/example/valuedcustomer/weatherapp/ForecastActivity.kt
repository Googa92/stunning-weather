package com.example.valuedcustomer.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_wiev)




       /* val listViewOfForecast = findViewById<ListView>(R.id.forecastListView)

        val myFavMovies = listOf<String>("4 feathers","Shaun of the Dead", "Iron Man", "Marvel movies")

        val adapter = ArrayAdapter (this,android.R.layout.simple_list_item_1, myFavMovies)

        listViewOfForecast.adapter = adapter
        */


        var retriever = WeatherRetriever()

        val callback = object :Callback<Weather>{
            var forecastStrings = mutableListOf<String>()

            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                println("It`s working")

                title = response?.body()?.query?.results?.channel?.title
               // println(response?.body()?.query?.results?.channel?.item?.forecast)

                var forecasts = response?.body()?.query?.results?.channel?.item?.forecast

                if (forecasts !=null){
                    for (forecast in forecasts){
                        val newString = "${forecast.day} ${forecast.date} - High:${forecast.high} Low:${forecast.low}"
                        forecastStrings.add(newString)
                    }
                }

                var listView = findViewById<ListView>(R.id.forecastListView)

                var adapter = ArrayAdapter (this@ForecastActivity,android.R.layout.simple_list_item_1, forecastStrings)
                listView.adapter=adapter
            }
            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                println("It`s not working")
            }
        }

        val searchTerm= intent.extras.getString("searchTerm")
        retriever.getForecast(callback, searchTerm )
    }
}
