package lotto.domain

import lotto.domain.enum.Priority

object LottoCommittee {
    fun createWinningTicket(input: String): LottoTicket {
        return LottoTicket(LottoNumber(input.split(",").map { it.toInt() }))
    }

    fun chooseBonusNumber(input: String, winningTicket: LottoTicket) {
        winningTicket.addBonusNumber(input.toInt())
    }

    fun calculateStatistics(
        lottos: List<LottoTicket>,
        winningTicket: LottoTicket
    ): Map<Int, Int> {
        val statistics = initStatistics()
        for (lotto in lottos) {
            statistics.merge(lotto.matchCount(winningTicket), 1, Int::plus)
        }
        return statistics
    }

    private fun initStatistics(): MutableMap<Int, Int> {
        val statistics = mutableMapOf<Int, Int>()
        for (priority in Priority.values()) {
            statistics[priority.matchCount] = 0
        }
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
