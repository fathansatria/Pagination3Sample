package com.fathansatria.pagination3sample.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.fathansatria.pagination3sample.R
import com.fathansatria.pagination3sample.adapters.MovieAdapter
import com.fathansatria.pagination3sample.databinding.ActivityMainBinding
import com.fathansatria.pagination3sample.utils.Injection
import com.fathansatria.pagination3sample.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var pagingAdapter : MovieAdapter
    private var searchKeyword:String = ""

    private var searchJob: Job? = null

    private fun search(query: String) {
        searchJob?.cancel()
        Log.i("PAGIN", "TRIGGERRED")
        searchJob = lifecycleScope.launch {
            viewModel.searchMovie(query).collect {
                Log.i("SIZE", it.toString())
                pagingAdapter.submitData(it)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, Injection.provideViewModelFactory())
            .get(MainActivityViewModel::class.java)

        pagingAdapter = MovieAdapter()
        binding.rvMovie.adapter = pagingAdapter
        if(searchKeyword.isNullOrEmpty()){
            rvMovie.visibility = View.GONE
            infoSearch.visibility = View.VISIBLE
        }else{
            rvMovie.visibility = View.VISIBLE
            infoSearch.visibility = View.GONE
        }
        searchKeyword = searchText.text.toString()
        searchBtn.setOnClickListener {
            search(searchKeyword)
        }
    }
}