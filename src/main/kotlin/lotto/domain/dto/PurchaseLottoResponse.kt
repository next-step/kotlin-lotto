package lotto.domain.dto

import lotto.domain.Lotto

data class PurchaseLottoResponse(
    val autoLottoCount: Int,
    val manualLottoCount: Int,
    val lottoTickets: List<Lotto>,
)
