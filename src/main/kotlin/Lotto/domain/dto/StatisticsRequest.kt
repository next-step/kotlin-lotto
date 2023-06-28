package Lotto.domain.dto

import Lotto.domain.Lotto
import Lotto.domain.WinningLotto

data class StatisticsRequest(
    val lottoTickets: List<Lotto>,
    val winningLotto: WinningLotto
)
