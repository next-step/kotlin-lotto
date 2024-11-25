package lotto.service

import lotto.domain.Lotto
import lotto.domain.Order
import lotto.domain.WinningResult
import lotto.util.NumberGenerator
import lotto.util.RandomNumberGenerator

class LottoSystem(private val numberGenerator: NumberGenerator = RandomNumberGenerator()) {
    fun createOrder(amount: Int): Order {
        return Order(amount, numberGenerator)
    }

    fun createWinNumbers(winningNumbers: Set<Int>): Lotto {
        return Lotto(winningNumbers)
    }

    fun createWinningResult(
        order: Order,
        winNumbers: Lotto,
    ): WinningResult {
        return WinningResult(order, winNumbers)
    }
}
