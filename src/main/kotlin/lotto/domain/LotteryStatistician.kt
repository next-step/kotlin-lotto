package lotto.domain

import java.util.EnumMap

class LotteryStatistician(
    private val targetLotto: Lotto,
    private val bonusNumber: Int,
) {
    fun statistics(lotties: Lotties): WinningStatistics {
        val statistics = initStatistics()

        lotties.all
            .groupingBy { LottoRank.of(it.matchCount(targetLotto), it.matchBonus(bonusNumber)) }
            .eachCount()
            .forEach { (rank, count) -> statistics[rank] = count }

        return WinningStatistics(
            purchaseAmount = lotties.all.size * Lotto.AMOUNT_PER_LOTTO,
            statistics = statistics,
        )
    }

    private fun initStatistics(): MutableMap<LottoRank, Int> =
        EnumMap<LottoRank, Int>(LottoRank::class.java).apply {
            LottoRank.entries.forEach { this[it] = 0 }
        }

    private fun Lotto.matchCount(lotto: Lotto): Int {
        return this.numbers.count { it in lotto.numbers }
    }

    private fun Lotto.matchBonus(number: Int): Boolean {
        return number in this.numbers
    }

}
