package com.acano.marvel.usecases

import com.example.klikintest.ui.model.UiResult
import com.example.klikintest.usecases.BaseUseCase

interface UseCasesInterface: BaseUseCase {
    suspend fun invokeList(): UiResult
}
