package lotto.controller

import lotto.domain.LottoResult

sealed interface EndLottoResponse {
    data class Success(
        val result: LottoResult,
    ) : EndLottoResponse

    data class Error(
        val message: String,
    ) : EndLottoResponse
}
