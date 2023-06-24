package step2Lotto.domain.dto

data class StatisticsRequest(
    val lottoTickets: List<Lotto>,
    val winningNumber: Lotto
)
