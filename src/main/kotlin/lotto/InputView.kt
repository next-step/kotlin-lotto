package lotto

class InputView(private val input: IInput) {
    fun askPurchaseAmount(): Int {
        return input.readPurchaseAmount()
    }

    fun askLastWeekWinningNumber(): List<Int> {
        return input.readLastWeekWinningNumbers()
    }
}