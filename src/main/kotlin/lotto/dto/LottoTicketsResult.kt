package lotto.dto

import lotto.domain.LottoTicket

data class LottoTicketsResult(val manualTicketsCount: Int, val tickets: List<LottoTicket>)
