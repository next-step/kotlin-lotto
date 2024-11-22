package lotto

class LottoSystem(private val numberGenerator: NumberGenerator = LottoNumberGenerator()) {
    fun createOrder(amount: Int): Order {
        return Order(amount, numberGenerator)
    }

    fun createWinNumbers(winningNumbers: Set<Int>): WinNumbers {
        return WinNumbers(winningNumbers)
    }

    fun createWinningResult(
        order: Order,
        winNumbers: WinNumbers,
    ): WinningResult {
        return WinningResult(order, winNumbers)
    }
}
