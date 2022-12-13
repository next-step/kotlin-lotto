package lotto.model

import lotto.model.Lotto.Companion.LOTTO_PRICE
import java.math.BigDecimal

class Lottos(val value: List<Lotto>) : List<Lotto> by value {
    val purchaseAmount = LOTTO_PRICE * BigDecimal(value.size)

    fun winningResultFor(winningNumbers: WinningNumbers): WinningResult {
        return WinningResult(this, winningNumbers)
    }
}
