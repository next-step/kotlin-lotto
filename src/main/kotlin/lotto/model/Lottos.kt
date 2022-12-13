package lotto.model

import java.math.BigDecimal

class Lottos(val value: List<Lotto>) : List<Lotto> by value {
    val buyPrice = Lotto.LOTTO_PRICE * BigDecimal(value.size)

    fun matchCounts(winningNumbers: WinningNumbers): List<Int> {
        return value.map { winningNumbers.matchCount(it) }
    }
}
