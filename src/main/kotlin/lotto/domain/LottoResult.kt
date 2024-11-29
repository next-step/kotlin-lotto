package lotto.domain

import lotto.domain.data.Lotto
import lotto.domain.data.LottoWinPlace

class LottoResult(
    private val minMatchingCount: Int = 3,
    private val matchCounter: LottoNumberMatchCounter = LottoNumberMatchCounter(),
) {
    private val resultMap = mutableMapOf<LottoWinPlace, Int>()

    fun getResults(
        winningLotto: Lotto,
        myLottoList: List<Lotto>,
    ): Map<LottoWinPlace, Int> {
        matchCounter.countMatchingNumbersAndGet(
            target = winningLotto,
            lottoList = myLottoList,
        ).values
            .filter { matchCount -> matchCount >= minMatchingCount }
            .forEach { matchCount ->
                var count = resultMap.getOrPut(LottoWinPlace.fromCount(matchCount)) { 0 }
                resultMap[LottoWinPlace.fromCount(matchCount)] = ++count
            }
        return resultMap
    }

    fun getTotalWinCount(): Int {
        return resultMap.values.sum()
    }
}
