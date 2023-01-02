package lotto.model

import lotto.model.Lotto.Companion.LOTTO_PRICE

class Lottos(val value: List<Lotto>) : List<Lotto> by value {
    val purchaseAmount = LOTTO_PRICE * value.size

    fun matchWith(winningNumbers: WinningNumbers): LottoPrizes {
        return LottoPrizes.of(this, winningNumbers)
    }
}
