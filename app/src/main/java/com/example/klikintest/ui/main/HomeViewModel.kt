package com.example.klikintest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klikintest.domain.Commerces
import com.example.klikintest.ui.model.UiResult
import com.example.klikintest.usecases.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class HomeViewModel() : ViewModel(), KoinComponent {
    private val useCases : UseCases by inject()


    private val _commercesList = MutableLiveData<List<Commerces>>()
    val commercesList: LiveData<List<Commerces>> = _commercesList


    private val _shortCommercesList = MutableLiveData<List<Commerces>>()
    val shortCommercesList: LiveData<List<Commerces>> = _shortCommercesList


    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage



     fun submitHeroList() {
        viewModelScope.launch {
            fetchCommercesList()
                .catch { err ->
                    _errorMessage.value= err.message
                }
                .collect { list ->
                    if(list.heroList!=null){
                        _commercesList.value = list.heroList!!.sortedBy { it.distance }
                    }else{
                        _errorMessage.value= list.errorMessage!!
                    }
                }
        }
    }


    private suspend fun fetchCommercesList() = flow<UiResult> {
        delay(700)
        useCases.invokeList().let {
           emit(it)
        }
    }.flowOn(Dispatchers.IO)



}
