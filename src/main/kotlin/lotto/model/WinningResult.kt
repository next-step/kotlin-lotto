package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

class WinningResult(
    val lottos: Lottos,
    val winningNumbers: WinningNumbers
) {
    fun getReturnRatio(): BigDecimal {
        val buyPrice = lottos.buyPrice
        val winningPrize = getTotalPrize()
        return winningPrize.divide(buyPrice, 2, RoundingMode.HALF_DOWN)
    }

    fun getCountOf(target: LottoPrize): Int {
        return lottos.prizesFor(winningNumbers)
            .count { it == target }
    }

    fun getTotalPrize(): BigDecimal {
        return lottos.map { winningNumbers.prizeOf(it) }
            .map { it.prize }
            .reduce(BigDecimal::add)
    }
}
