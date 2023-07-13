package lotto.domain.dto

import lotto.domain.LottoTickets

class PurchaseLottoResponse(
    val autoLottoCount: Int,
    val manualLottoCount: Int,
    val lottoTickets: LottoTickets,
)
