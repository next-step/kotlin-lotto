package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoWinPlace
import java.math.BigDecimal

class LottoResult(
    private val winningLotto: Lotto,
    private val myLottoList: List<Lotto>,
    private val minMatchingCount: Int = 3,
    private val matchCounter: LottoNumberMatchCounter = LottoNumberMatchCounter(),
) {
    private val resultMap = LottoWinPlace.entries.associateWith { 0 }.toMutableMap()

    fun getResults(): Map<LottoWinPlace, Int> {
        matchCounter.countMatchingNumbersAndGet(
            target = winningLotto,
            lottoList = myLottoList,
        ).values
            .filter { matchCount -> matchCount >= minMatchingCount }
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
}
