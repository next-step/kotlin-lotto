package lotto.domain

import lotto.domain.enums.PrizeType
import lotto.domain.lotto.Lotto
import lotto.domain.lotto.WinningLotto

class LottoPrize(
    userLottoList: List<Lotto>,
    private val winningLotto: WinningLotto
) {

    private val _prizeResult: MutableMap<Int, Int> = (3..6)
        .associateWith { 0 } as MutableMap<Int, Int>

    val prizeResult: Map<Int, Int> = _prizeResult

    init {
        userLottoList
            .forEach { recordLottoPrize(it) }
    }

    fun totalPrizeMoney(): Int = _prizeResult
        .filter { it.value != 0 }
        .map { PrizeType.findPrizeMoney(it.key) }
        .sum()

    private fun recordLottoPrize(lotto: Lotto) {
        val answer = lotto.lottoNumber.filter { winningLotto.containsLottoNumber(it) }.size

        if (answer >= 3) _prizeResult[PrizeType.containsMatch(answer)] = +1
    }
}
