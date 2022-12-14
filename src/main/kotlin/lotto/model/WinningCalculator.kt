package lotto.model

import java.lang.NullPointerException
import kotlin.math.round

class WinningCalculator(lottoTickets: List<LottoTicket>, winnerNumber: WinnerNumber) {
    private val resultWinningStatistics = WinningStatistics(
        mutableMapOf(
            Rank.FIRST to 0,
            Rank.THIRD to 0, Rank.FOURTH to 0, Rank.FIFTH to 0, Rank.NO_LUCK to 0
        ),
        0.0
    )

    val winningStatistics = generateWinningStatistics(lottoTickets, winnerNumber)

    private fun generateWinningStatistics(
        lottoTickets: List<LottoTicket>,
        winnerNumber: WinnerNumber
    ): WinningStatistics {
        for (lottoTicket in lottoTickets) {
            setGrade(lottoTicket.lottoNumbers.toSet().intersect(winnerNumber.winnerNumbers.toSet()).size)
        }

        calculateRate(lottoTickets.size)

        return resultWinningStatistics
    }

    private fun setGrade(count: Int) {
        val rank = Rank.of(count)
        try {
            resultWinningStatistics.ranks[rank] = resultWinningStatistics.ranks[rank]!! + 1
        } catch (e: NullPointerException) {
        }
    }

    fun calculateRate(quantity: Int): Double {
        var totalReward = 0.0
        for (rank in resultWinningStatistics.ranks) {
            totalReward += (rank.value * rank.key.reward).toDouble()
        }
        resultWinningStatistics.rate = round(
            totalReward / (quantity * 1000) * ROUND
        ) / ROUND

        return resultWinningStatistics.rate
    }

    companion object {
        const val ROUND = 100
    }
}
