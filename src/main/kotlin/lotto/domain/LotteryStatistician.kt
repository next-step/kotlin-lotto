package lotto.domain

import java.util.*

class LotteryStatistician(
    targetLottoStr: String,
) {
    private val targetLotto = Lotto(
        targetLottoStr.split(",").map { it.trim().toIntOrNull().validate() },
    )

    fun statistics(lotties: List<Lotto>): WinningStatistics {
        val statistics = initStatistics()

        lotties
            .groupingBy { LottoRank.of(it.matchCount(targetLotto)) }
            .eachCount()
            .forEach { (rank, count) -> rank?.let { statistics[it] = count } }

        return WinningStatistics(
            purchaseAmount = lotties.size * Lotto.AMOUNT_PER_LOTTO,
            statistics = statistics,
        )
    }

    private fun Int?.validate(): Int {
        return this?.takeIf { it in LottoGenerator.RANGE }
            ?: throw IllegalArgumentException("로또 숫자의 범위는 ${LottoGenerator.RANGE} 입니다")
    }

    private fun initStatistics(): MutableMap<LottoRank, Int> =
        EnumMap<LottoRank, Int>(LottoRank::class.java).apply {
            LottoRank.entries.forEach { this[it] = 0 }
        }

    private fun Lotto.matchCount(lotto: Lotto): Int {
        return this.numbers.count { it in lotto.numbers }
    }

}
