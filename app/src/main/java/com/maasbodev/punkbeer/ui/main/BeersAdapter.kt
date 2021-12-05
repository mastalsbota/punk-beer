package com.maasbodev.punkbeer.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.R
import com.maasbodev.punkbeer.databinding.ViewBeerBinding
import com.maasbodev.punkbeer.ui.common.basicDiffUtil
import com.maasbodev.punkbeer.ui.common.inflate
import com.maasbodev.punkbeer.ui.common.loadUrl

class BeersAdapter(private val listener: (Beer) -> Unit) :
    RecyclerView.Adapter<BeersAdapter.ViewHolder>() {

    var beers: List<Beer> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_beer, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beer = beers[position]
        holder.bind(beer)
    }

    override fun getItemCount(): Int = beers.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewBeerBinding.bind(view)

        fun bind(beer: Beer) = with(binding) {
            beerName.text = beer.name
            beerCover.loadUrl("https://image.tmdb.org/t/p/w185/${beer.image_url}")
        }

    }

}