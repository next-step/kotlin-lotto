package lotto.model

import kotlin.math.round

class WinningCalculator(lottoTickets: List<TicketStrategy>, winnerNumber: WinnerNumber) {
    private val resultWinningStatistics = WinningStatistics(0, 0, 0, 0, 0.0)
    val winningStatistics = generateWinningStatistics(lottoTickets, winnerNumber)

    private fun generateWinningStatistics(
        lottoTickets: List<TicketStrategy>,
        winnerNumber: WinnerNumber
    ): WinningStatistics {
        for (lottoTicket in lottoTickets) {
            setGrade(lottoTicket.getLottoTicketNumbers().toSet().intersect(winnerNumber.winnerNumbers.toSet()).size)
        }

        calculateRate(lottoTickets.size)

        return resultWinningStatistics
    }

    private fun setGrade(count: Int) {
        when (count) {
            3 -> resultWinningStatistics.matchThree++
            4 -> resultWinningStatistics.matchFour++
            5 -> resultWinningStatistics.matchFive++
            6 -> resultWinningStatistics.matchSix++
        }
    }

    fun calculateRate(quantity: Int): Double {
        resultWinningStatistics.rate = round(
            (
                (
                    resultWinningStatistics.matchThree * MATCH_THREE +
                        resultWinningStatistics.matchFour * MATCH_FOUR +
                        resultWinningStatistics.matchFive * MATCH_FIVE +
                        resultWinningStatistics.matchSix * MATCH_SIX
                    ).toDouble() / (quantity * 1000)
                ) * ROUND
        ) / ROUND
        return resultWinningStatistics.rate
    }

    companion object {
        const val MATCH_THREE = 5000
        const val MATCH_FOUR = 50000
        const val MATCH_FIVE = 1500000
        const val MATCH_SIX = 2000000000
        const val ROUND = 100
    }
}
