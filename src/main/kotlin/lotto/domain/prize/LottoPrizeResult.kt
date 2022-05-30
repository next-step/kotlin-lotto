package lotto.domain.prize

import lotto.domain.Lotto
import lotto.domain.WinningLotto

class LottoPrizeResult(winningLotto: WinningLotto, lottoBought: List<Lotto>) {
    val prizes: List<LottoPrize> = lottoBought
        .map {
            val numberOfMatches = winningLotto.getNumberOfMatchingNumbers(it)
            val matchesBonus = winningLotto.matchesBonus(it)

            LottoPrize.of(numberOfMatches, matchesBonus)
        }

    val totalPrizeAmount: Int = prizes.sumOf { it.prizeAmount }

    fun numberOf(lottoPrize: LottoPrize) = prizes.filter { it == lottoPrize }.size
}
