package com.maasbodev.punkbeer.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.ui.common.ScopedViewModel
import com.maasbodev.usecases.GetAllBeers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getAllBeers: GetAllBeers) : ScopedViewModel() {
    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val beers: List<Beer>) : UiModel()
        class Navigation(val beer: Beer) : UiModel()
    }

    init {
        initScope()
    }

    fun onBeerClicked(beer: Beer) {
        _model.value = UiModel.Navigation(beer)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}