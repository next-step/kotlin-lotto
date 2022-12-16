package lotto.domain

import lotto.LottoNumberSelector

data class LottoTicket(
    val numbers: Set<Int> = LottoNumberSelector.select(),
)
