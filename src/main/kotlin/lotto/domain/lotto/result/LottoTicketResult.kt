package lotto.domain.lotto.result

import lotto.domain.lotto.ticket.LottoTicket

data class LottoTicketResult(
    val matchCount: Int,
    val isBonus: Boolean
) {

    init {
        require(matchCount in (0..LottoTicket.TOTAL_COUNT_LOTTO_NUMBER)) {
            "matchCount should be between ${0} and ${LottoTicket.TOTAL_COUNT_LOTTO_NUMBER}"
        }
    }
}
