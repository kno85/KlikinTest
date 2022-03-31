package com.example.klikintest.usecases

import com.example.klikintest.ui.model.UiResult

interface UseCasesInterface: BaseKoin {
    suspend fun invokeList(): UiResult
}
