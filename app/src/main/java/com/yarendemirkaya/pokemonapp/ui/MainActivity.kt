package com.yarendemirkaya.pokemonapp.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yarendemirkaya.pokemonapp.R
import com.yarendemirkaya.pokemonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        viewModel.getAllPokemons()
        viewModel.pokemonResponse.observe(this) { response ->
            if (response.isSuccessful) {
                val pokemonResponse = response.body()
                binding.tvCount.text = pokemonResponse?.count.toString()

            } else {
                val errorMessage = response.message()
            }
        }
        return super.onCreateView(name, context, attrs)
    }
}