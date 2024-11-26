package lotto.domain

import java.util.EnumMap

class LotteryStatistician(
    targetLottoStr: String,
    private val bonusNumber: Int,
) {
    private val targetLotto = Lotto(
        targetLottoStr.split(",").map { it.trim().toIntOrNull().validate() },
    )

    fun statistics(lotties: List<Lotto>): WinningStatistics {
        val statistics = initStatistics()

        lotties
            .groupingBy { LottoRank.of(it.matchCount(targetLotto), it.matchBonus(bonusNumber)) }
            .eachCount()
            .forEach { (rank, count) -> statistics[rank] = count }

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

    private fun Lotto.matchBonus(number: Int): Boolean {
        return number in this.numbers
    }

}
