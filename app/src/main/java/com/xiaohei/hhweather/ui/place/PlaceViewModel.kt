package com.xiaohei.hhweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.xiaohei.hhweather.logic.model.Place
import com.xiaohei.hhweather.logic.repository.Repository

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData) {
        Repository.searchPlaces(it)
    }

    fun searchPlace(query: String) {
        searchLiveData.value = query
    }

}