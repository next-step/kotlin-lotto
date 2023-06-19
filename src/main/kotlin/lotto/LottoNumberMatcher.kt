package lotto

import lotto.domain.Lotto
import lotto.enums.LottoRank

class LottoNumberMatcher {

    fun lottoCheck(winningLotto: Lotto, lottoBundle: List<Lotto>, bonusNumber: Int): List<LottoRank> {

        val result = mutableListOf<LottoRank>()
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.numbers.forEach { number ->
                if (winningLotto.numbers.contains(number)) {
                    count++
                }
            }
            if (count == BONUS_WINNING_COUNT && lotto.numbers.contains(bonusNumber)) {
                return@forEach
            }
            if (count != 0) {
                result.add(LottoRank.getLottoRankByCount(count))
            }
        }
        return result.toList()
    }

    fun bonusLottoCheck(winningLotto: Lotto, lottoBundle: List<Lotto>, bonusNumber: Int): Int {

        var result = 0
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.numbers.forEach { number ->
                if (winningLotto.numbers.contains(number)) {
                    count++
                }
            }
            if (count == BONUS_WINNING_COUNT && lotto.numbers.contains(bonusNumber)) {
                result++
            }
        }
        return result
    }

    fun lottoResultGroup(collectLottoRanks: List<LottoRank>): Map<Int, Int> {
        return collectLottoRanks.sorted().groupingBy { it.count }.eachCount()
    }

    companion object {
        private const val BONUS_WINNING_COUNT = 5
    }
}
