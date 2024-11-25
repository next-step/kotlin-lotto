package lotto

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
