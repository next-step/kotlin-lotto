package lotto.domain.selling

import lotto.domain.lotto.LottoTicket

data class PaymentResult(
    val money: Int,
    val lottoTickets: List<LottoTicket>,
    val change: Int
)
