package lotto.controller

import lotto.domain.LottoTicket

sealed interface PurchaseResponse{
    data class Success(
        val ticket: LottoTicket,
    ) : PurchaseResponse

    data class Error(
        val message: String,
    ) : PurchaseResponse
}
