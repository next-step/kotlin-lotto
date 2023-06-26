package step2Lotto.domain.dto

import step2Lotto.domain.Lotto
import step2Lotto.domain.WinningNumber

data class StatisticsRequest(
    val lottoTickets: List<Lotto>,
    val winningNumber: WinningNumber
)
