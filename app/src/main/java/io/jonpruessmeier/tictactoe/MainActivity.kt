package io.jonpruessmeier.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.jonpruessmeier.tictactoe.model.Game

class MainActivity : AppCompatActivity() {
    private lateinit var game: Game;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}