package com.akshay.fetchassignment.repository

import com.akshay.fetchassignment.model.HiringListItem
import com.akshay.fetchassignment.network.APIService
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject



@ViewModelScoped
class HiringRepo @Inject constructor(val api: APIService) {

    suspend fun getHiring() : List<HiringListItem>{
        return api.getHiringDetails()
    }
}


