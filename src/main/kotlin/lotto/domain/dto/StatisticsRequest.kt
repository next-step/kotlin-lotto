package lotto.domain.dto

import lotto.domain.LottoTickets
import lotto.domain.WinningLotto

data class StatisticsRequest(
    val lottoTickets: LottoTickets,
    val winningLotto: WinningLotto
)
