package Lotto.domain.dto

import Lotto.domain.Lotto
import Lotto.domain.WinningNumber

data class StatisticsRequest(
    val lottoTickets: List<Lotto>,
    val winningNumber: WinningNumber
)
