package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoWinPlace
import java.math.BigDecimal

class LottoResult(
    private val winningLotto: Lotto,
    private val myLottoList: List<Lotto>,
) {
    private val resultMap = LottoWinPlace.entries.associateWith { 0 }.toMutableMap()

    fun getResults(): Map<LottoWinPlace, Int> {
        countMatchesPerList(
            target = winningLotto.value,
            list = myLottoList.map { it.value },
        )
            .filter { matchCount -> matchCount >= MIN_MATCHING_COUNT }
            .forEach { matchCount ->
                var count = resultMap.getOrElse(LottoWinPlace.fromCount(matchCount)) { 0 }
                resultMap[LottoWinPlace.fromCount(matchCount)] = ++count
            }
        return resultMap
    }

    fun getTotalProfit(): BigDecimal {
        return resultMap
            .map { it.key.prizeMoney * it.value.toBigDecimal() }
            .fold(BigDecimal.ZERO, BigDecimal::add)
    }

    private fun countMatchesPerList(
        target: List<Int>,
        list: List<List<Int>>,
    ): List<Int> {
        return list.map { it.count { number -> target.contains(number) } }
    }

    companion object {
        private const val MIN_MATCHING_COUNT = 3
    }
}
