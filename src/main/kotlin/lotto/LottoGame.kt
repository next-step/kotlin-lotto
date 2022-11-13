package lotto

private const val TICKET_PRICE = 1000

class LottoGame(
    val lottoTickets: List<LottoTicket>,
    val winnerTicket: WinnerTicket
) {
    fun calculateProfitRate(): Double {
        val winningMoney = lottoTickets.map { winnerTicket.drawResult(it) }
            .sumOf { it.winningMoney }
        return winningMoney.toDouble() / (lottoTickets.size * TICKET_PRICE)
    }
}