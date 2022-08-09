package com.milligher.petapp.presentation.activities.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.milligher.petapp.App
import com.milligher.petapp.R
import com.milligher.petapp.databinding.ActivityDetailBinding
import javax.inject.Inject


class DetailActivity : AppCompatActivity() {

    var ANIME_ID = 0

    private lateinit var _binding: ActivityDetailBinding
    private val mBinding get() = _binding

    @Inject
    lateinit var viewModelFactory: DetailViewModelFactory

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        ANIME_ID = intent.getIntExtra("ANIME_ID", 1)

        (applicationContext as App).appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        viewModel.setAnimeId(ANIME_ID)
        viewModel.getItem()
        viewModel.getLiveDataItem().observe(this) {
            mBinding.detailProgressBar.visibility = View.GONE
            Glide.with(this)
                .load(it.images.jpg.image_url)
                .error(R.drawable.ic_launcher_foreground)
                .into(mBinding.detailImage)
            mBinding.detailTitle.text = it.title
            mBinding.detailYear.text = it.year.toString()
            mBinding.detailEpisodes.text = it.episodes.toString()
            mBinding.detailDuration.text = it.duration
            mBinding.detailSynopsis.text = it.synopsis
        }
    }

    companion object {

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("ANIME_ID", id)
            return intent
        }
    }
}