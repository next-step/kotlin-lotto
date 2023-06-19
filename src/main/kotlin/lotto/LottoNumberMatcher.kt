package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.enums.LottoRank

class LottoNumberMatcher {

    fun lottoCheck(winningLotto: Lotto, lottoBundle: List<Lotto>, bonusLottoNumber: LottoNumber): List<LottoRank> {

        val result = mutableListOf<LottoRank>()
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.numbers.forEach { number ->
                if (winningLotto.numbers.contains(number)) {
                    count++
                }
            }
            if (count == BONUS_WINNING_COUNT && lotto.numbers.contains(bonusLottoNumber.number)) {
                return@forEach
            }
            if (count != 0) {
                result.add(LottoRank.getLottoRankByCount(count))
            }
        }
        return result.toList()
    }

    fun bonusLottoCheck(winningLotto: Lotto, lottoBundle: List<Lotto>, bonusLottoNumber: LottoNumber): Int {

        var result = 0
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.numbers.forEach { number ->
                if (winningLotto.numbers.contains(number)) {
                    count++
                }
            }
            if (count == BONUS_WINNING_COUNT && lotto.numbers.contains(bonusLottoNumber.number)) {
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
