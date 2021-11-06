package lotto.domain

import lotto.domain.enums.PrizeType

class LottoResult(userLottoList: List<Lotto>, private val winningLotto: WinningLotto) {

    private val prizeResult: MutableMap<Int, Int> = (3..6)
        .associateWith { 0 } as MutableMap<Int, Int>

    init {

        prizeResult[0] = 0

        userLottoList
            .forEach { recordLottoPrize(it) }

    }

    private fun recordLottoPrize(lotto: Lotto) {
        val answer = lotto.lottoNumber.filter { winningLotto.containsLottoNumber(it) }.size
        prizeResult[PrizeType.findAnswer(answer)] = +1
    }

    fun allPrizeResult(): MutableMap<Int, Int> {
        return prizeResult
    }

    fun totalPrizeMoney(): Int = prizeResult
        .filter { it.key >= 3 && it.value != 0 }
        .map { PrizeType.findPrizeMoney(it.key) }
        .sum()


}