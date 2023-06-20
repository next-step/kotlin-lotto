package lotto.domain

import lotto.domain.LottoMachine.Companion.LOTTO_COST
import java.math.BigDecimal
import java.math.RoundingMode

class LottoResultSummary(private val results: List<LottoResult>) {

    private val gradeCountMap: Map<LottoResult, Int> = results.groupingBy { it }.eachCount()

    fun winResults(): List<Pair<LottoResult, Int>> {
        return LottoResult.values()
            .reversed()
            .filter { it != LottoResult.LOSE }
            .map { Pair(it, gradeCountMap[it] ?: 0) }
    }

    fun rateOfReturn(): BigDecimal {
        val totalLottoCount = results.size
        val totalCost = totalLottoCount * LOTTO_COST
        val totalPrice = results.sumOf { it.price }
        return totalPrice.toBigDecimal().divide(totalCost.toBigDecimal(), 2, RoundingMode.HALF_UP)
    }
}
