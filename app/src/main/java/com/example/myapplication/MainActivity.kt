package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder


data class Player(val name: String, val text:String, val url: String)

class MainActivity : AppCompatActivity() {

    private lateinit var players: List<Player>
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recycler)
        val resultString = application.assets
            .open("players.json")
            .bufferedReader()
            .use { it.readText() }
        val gson = GsonBuilder().create()
        players = gson.fromJson(resultString,Array<Player>::class.java).toList()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyAdapter(players)

    }
}