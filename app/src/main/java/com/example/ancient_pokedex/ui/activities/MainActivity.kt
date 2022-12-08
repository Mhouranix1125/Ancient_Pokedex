package com.example.ancient_pokedex.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.ancient_pokedex.R
import com.example.ancient_pokedex.databinding.ActivityMainBinding
import com.example.ancient_pokedex.ui.fragments.DexHomeFragment
import com.example.ancient_pokedex.ui.fragments.PokemonPageFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val dexHomeFragment : DexHomeFragment = DexHomeFragment()
    val pokemonPageFragment : PokemonPageFragment = PokemonPageFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d("Hourani", "Main Activity: ",)

        replaceFragment(dexHomeFragment)
    }

     fun replaceFragment(fragment: Fragment) {
         val fragmentManager = supportFragmentManager
         val fragmentTransaction = fragmentManager.beginTransaction()
         fragmentTransaction.replace(R.id.frameLayout, fragment)
         fragmentTransaction.addToBackStack(null)
         fragmentTransaction.commit()
    }

    //TODO: Figure out how to properly switch out frags
/*
    private fun loadingData() {
        lifecycleScope.launch{
            viewModel.listData.collect{ pagingData->
                pokemonAdapter.submitData(pagingData)
            }
        }
    }

    private fun setupRv(){
        pokemonAdapter = PokemonPagingAdapter(this)
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL
            )
            adapter = pokemonAdapter
            setHasFixedSize(true)
        }
    }

    override fun onItemClicked(position: Int) {
        Toast.makeText(this, "${pokemonAdapter.peek(position)?.name} clicked", Toast.LENGTH_SHORT).show()
    }
    */
}