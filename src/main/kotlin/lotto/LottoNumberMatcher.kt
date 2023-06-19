package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.enums.LottoRank

class LottoNumberMatcher {

    fun checkLotto(winningLotto: Lotto, lottoBundle: List<Lotto>, bonusLottoNumber: LottoNumber): List<LottoRank> {

        val result = mutableListOf<LottoRank>()
        lottoBundle.forEach { lotto ->
            val count = countLottoNumber(lotto, winningLotto)
            if (count == BONUS_WINNING_COUNT && lotto.numbers.contains(bonusLottoNumber.number)) {
                return@forEach
            }
            if (count != 0) {
                result.add(LottoRank.getLottoRankByCount(count))
            }
        }
        return result.toList()
    }

    fun checkBonusLotto(winningLotto: Lotto, lottoBundle: List<Lotto>, bonusLottoNumber: LottoNumber): Int {

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

    private fun countLottoNumber(lotto: Lotto, winningLotto: Lotto): Int {
        var count = 0
        lotto.numbers.forEach { number ->
            if (winningLotto.numbers.contains(number)) {
                count++
            }
        }
        return count
    }

    fun lottoResultGroup(collectLottoRanks: List<LottoRank>): Map<Int, Int> {
        return collectLottoRanks.sorted().groupingBy { it.count }.eachCount()
    }

    companion object {
        private const val BONUS_WINNING_COUNT = 5
    }
}
