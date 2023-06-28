package lotto.domain.dto

import lotto.domain.Lotto
import lotto.domain.WinningLotto

data class StatisticsRequest(
    val lottoTickets: List<Lotto>,
    val winningLotto: WinningLotto
)
