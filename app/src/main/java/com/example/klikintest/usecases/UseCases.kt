package com.example.klikintest.usecases

import com.acano.marvel.usecases.UseCasesInterface
import com.example.klikintest.repository.DataRepository
import com.example.klikintest.ui.model.UiResult

class UseCases(val dataRepository: DataRepository) : UseCasesInterface {
    override suspend fun invokeList(): UiResult {
        return dataRepository.getList()
    }
}
