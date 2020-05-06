package com.example.networkingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var vollyeRequest: RequestQueue? = null
    val link =
        "https://www.megadistudio.com/complete-android-developer-course-source-files/string.html"
    val movieLink = "http://netflixroulette.net/api/api.php?director=Quentin%20Tarantino"
    val earthquakeLink =
        "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vollyeRequest = Volley.newRequestQueue(this)
        //getString(link)
//        getJsonArray(movieLink)
        getJsonObject(earthquakeLink)
    }

    fun getJsonObject(url: String) {
        val jsonObjectReq =
            JsonObjectRequest(Request.Method.GET, url, Response.Listener { response: JSONObject ->
                try {
//                    var type = response.getString("type")
                    var metadata = response.getJSONObject("metadata")
                    var array = response.getJSONArray("features")
                    Log.d("TYPE",metadata.getString("title"))
                }catch (e:JSONException){
                    e.printStackTrace()
                }
            }, Response.ErrorListener {
                error: VolleyError? ->
                try {

                }catch (e:JSONException){
                    e.printStackTrace()
                }
            })
        vollyeRequest!!.add(jsonObjectReq)
    }

    fun getString(url: String) {
        val stringReq = StringRequest(Request.Method.GET, url,
            Response.Listener { response: String? ->
                try {
                    Log.d("RESPONSE", response)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error: VolleyError? ->
                try {
                    Log.d("Error", error.toString())
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            })
        vollyeRequest!!.add(stringReq)
    }

    fun getJsonArray(url: String) {
        val jasonArrayReq = JsonArrayRequest(Request.Method.GET,
            url,
            Response.Listener { response: JSONArray ->
                try {
                    Log.d("RESPONSE", response.toString())
                    for (i in 0 until response.length()) {
                        var item = response.getJSONObject(i)
                        var name =
                            item.getString("first_name") //access the response object property
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error: VolleyError? ->
                try {
                    Log.d("Error", error.toString())
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            })

        vollyeRequest!!.add(jasonArrayReq)
    }
}
