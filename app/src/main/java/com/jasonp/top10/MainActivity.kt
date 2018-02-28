package com.jasonp.top10

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView_main.layoutManager = LinearLayoutManager(this )



        fetchJSON()

    }

    fun fetchJSON(){
        println("Fetching JSON now")

        val url= "https://rss.itunes.apple.com/api/v1/us/apple-music/hot-tracks/all/10/explicit.json"

        val request= Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call?, response: Response?){

                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()


                val myStuff = gson.fromJson(body, Format::class.java)


                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(myStuff)
                }

            }

            override fun onFailure(call: Call?, e: IOException?){
                println("Failed to execute code")
            }


        })

    }

}








