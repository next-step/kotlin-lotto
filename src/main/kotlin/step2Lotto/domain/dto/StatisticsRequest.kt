package step2Lotto.domain.dto

import step2Lotto.domain.Lotto

data class StatisticsRequest(
    val lottoTickets: List<Lotto>,
    val winningNumber: Lotto
)
