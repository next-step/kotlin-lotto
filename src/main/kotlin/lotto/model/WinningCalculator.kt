package lotto.model

import kotlin.math.round

class WinningCalculator(lottoTickets: List<LottoTicket>, winnerNumber: WinnerNumber, bonusNumber: Int) {
    private val resultWinningStatistics = WinningStatistics(
        listOf(
            RankCounter(Rank.FIFTH, 0),
            RankCounter(Rank.FOURTH, 0),
            RankCounter(Rank.THIRD, 0),
            RankCounter(Rank.SECOND, 0),
            RankCounter(Rank.FIRST, 0),
            RankCounter(Rank.NO_LUCK, 0)
        )
            .groupBy { it.rank },
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
        val rank = Rank.of(count, isMatchBonusNumber(bonusNumber))
        resultWinningStatistics.ranks[rank]?.get(0)?.count =
            (resultWinningStatistics.ranks[rank]?.get(0)?.count ?: 0) + 1
    }

    private fun isMatchBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber != 0
    }

    fun calculateRate(quantity: Int): Double {
        var totalReward = 0.0
        for (rank in resultWinningStatistics.ranks) {
            totalReward += (rank.value[0].count * rank.key.reward).toDouble()
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
