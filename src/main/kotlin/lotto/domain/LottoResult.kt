package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoWinPlace
import java.math.BigDecimal

class LottoResult(
    private val winningLotto: Lotto,
    myLottoList: List<Lotto>,
) {
    val resultMap: Map<LottoWinPlace, Int>

    init {
        resultMap = LottoWinPlace.entries.associateWith { 0 }.toMutableMap()
        myLottoList.forEach { lotto ->
            val matchCount = lotto.countMatchesOf(winningLotto)
            if (matchCount >= MIN_MATCHING_COUNT) {
                val winPlace = LottoWinPlace.fromCount(matchCount)
                var winCount = resultMap.getOrDefault(winPlace, 0)
                resultMap[winPlace] = ++winCount
            }
        }
    }

    fun getTotalProfit(): BigDecimal {
        return resultMap
            .map { it.key.prizeMoney * it.value.toBigDecimal() }
            .fold(BigDecimal.ZERO, BigDecimal::add)
    }

    private fun Lotto.countMatchesOf(lotto: Lotto): Int {
        return this.value.count { lotto.value.contains(it) }
    }

    companion object {
        private const val MIN_MATCHING_COUNT = 3
    }
}
