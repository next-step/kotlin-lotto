package lotto.model

import kotlin.math.round

class WinningCalculator(lottoTickets: List<LottoTicket>, winnerNumber: WinnerNumber, bonusNumber: Int) {
    private val resultWinningStatistics = WinningStatistics(
        mutableMapOf(
            Rank.FIFTH to 0, Rank.FOURTH to 0,
            Rank.THIRD to 0, Rank.SECOND to 0, Rank.FIRST to 0, Rank.NO_LUCK to 0
        ),
        0.0
    )

    val winningStatistics = generateWinningStatistics(lottoTickets, winnerNumber, bonusNumber)

    private fun generateWinningStatistics(
        lottoTickets: List<LottoTicket>,
        winnerNumber: WinnerNumber,
        bonusNumber: Int
    ): WinningStatistics {
        for (lottoTicket in lottoTickets) {
            val restNumber = lottoTicket.lottoNumbers.toSet().subtract(winnerNumber.winnerNumbers.toSet())
            val findingBonusNumber = restNumber.find { it == bonusNumber } ?: 0
            setGrade(
                lottoTicket.lottoNumbers.toSet().intersect(winnerNumber.winnerNumbers.toSet()).size,
                findingBonusNumber
            )
        }

        calculateRate(lottoTickets.size)

        return resultWinningStatistics
    }

    private fun setGrade(count: Int, bonusNumber: Int) {
        val rank = Rank.of(count, isMatchBonusNumber(count, bonusNumber))
        resultWinningStatistics.ranks[rank] = (resultWinningStatistics.ranks[rank] ?: 0) + 1
    }

    private fun isMatchBonusNumber(count: Int, bonusNumber: Int): Boolean {
        return count == Rank.SECOND.match && bonusNumber != 0
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
