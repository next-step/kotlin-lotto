package lotto

class LottoSystem(private val numberGenerator: NumberGenerator = LottoNumberGenerator()) {
    fun createOrder(amount: Int): Order {
        return Order(amount, numberGenerator)
    }

    fun createWinNumbers(): WinNumbers {
        return WinNumbers(numberGenerator.generate())
    }

    fun createWinningResult(
        order: Order,
        winNumbers: WinNumbers,
    ): WinningResult {
        return WinningResult(order, winNumbers)
    }
}
