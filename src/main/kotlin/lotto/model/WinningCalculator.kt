package lotto.model

import kotlin.math.round

class WinningCalculator(
    automaticLottoTickets: List<LottoTicket>,
    winnerTicket: LottoTicket,
    bonusNumber: Int
) {
    private val resultWinningStatistics = WinningStatistics(
        listOf(
            RankCounter(Rank.FIFTH, 0),
            RankCounter(Rank.FOURTH, 0),
            RankCounter(Rank.THIRD, 0),
            RankCounter(Rank.SECOND, 0),
            RankCounter(Rank.FIRST, 0),
            RankCounter(Rank.NO_LUCK, 0)
        ).groupBy { it.rank },
        0.0
    )

    val winningStatistics = generateWinningStatistics(automaticLottoTickets, winnerTicket, bonusNumber)

    private fun generateWinningStatistics(
        automaticLottoTickets: List<LottoTicket>,
        winnerTicket: LottoTicket,
        bonusNumber: Int
    ): WinningStatistics {
        for (automaticLottoTicket in automaticLottoTickets) {
            val restNumber = automaticLottoTicket.values.toSet().subtract(winnerTicket.values.toSet())
            val findingBonusNumber = restNumber.find { it == bonusNumber } ?: 0
            setGrade(
                automaticLottoTicket.values.toSet().intersect(winnerTicket.values.toSet()).size,
                findingBonusNumber
            )
        }

        calculateRate(automaticLottoTickets.size)

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
            totalReward / (quantity * TICKET_PRICE) * ROUND
        ) / ROUND

        return resultWinningStatistics.rate
    }

    companion object {
        private const val ROUND = 100
        private const val TICKET_PRICE = 1000
    }
}
