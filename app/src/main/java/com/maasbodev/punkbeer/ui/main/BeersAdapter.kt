package com.maasbodev.punkbeer.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.ui.common.basicDiffUtil
import com.maasbodev.punkbeer.ui.common.inflate

class BeersAdapter(private val listener: (Beer) -> Unit):
    RecyclerView.Adapter<BeersAdapter.ViewHolder>() {

    var beers: List<Beer> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = {old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

}