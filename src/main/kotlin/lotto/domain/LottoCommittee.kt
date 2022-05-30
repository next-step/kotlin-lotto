package lotto.domain

import lotto.domain.enum.Priority

object LottoCommittee {
    private const val LOTTO_NUMBER_COUNT = 6
    private val MATCHING_NUMBER_RANGE = 3..6
    private val LOTTO_VALID_RANGE = 1..45

    fun createWinningTicket(input: String): LottoTicket {
        return LottoTicket(input.split(",").map { it.toInt() })
    }

    fun calculateStatistics(
        lottos: List<LottoTicket>,
        winningTicket: LottoTicket
    ): Map<Int, Int> {
        val statistics = initStatistics()
        for (lotto in lottos) {
            val matchCount = lotto.matchCount(winningTicket)
            statistics.merge(matchCount, 1, Int::plus)
        }
        return statistics
    }

    private fun initStatistics(): MutableMap<Int, Int> {
        val statistics = mutableMapOf<Int, Int>()
        for (priority in Priority.values()) {
            statistics[priority.matchCount] = 0
        }
        println(statistics)
        return statistics
    }

    fun calculateReturnRate(price: Int, statistics: Map<Int, Int>): Double {
        return (calculateReturnPrice(statistics) / price.toDouble())
    }

    private fun calculateReturnPrice(statistics: Map<Int, Int>): Int {
        var returnPrice = 0

        for ((matchNumber, matchCount) in statistics) {
            returnPrice += matchCount * Priority.getPrice(matchNumber)
        }

        return returnPrice
    }
}
