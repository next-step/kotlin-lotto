package lotto.model

import java.math.BigDecimal

class Lottos(val value: List<Lotto>) : List<Lotto> by value {
    val buyPrice = Lotto.LOTTO_PRICE * BigDecimal(value.size)

    fun prizesFor(winningNumbers: WinningNumbers): List<LottoPrize> {
        return value.map(winningNumbers::prizeOf)
    }
}
