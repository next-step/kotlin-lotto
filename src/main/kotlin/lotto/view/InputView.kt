package lotto.view

class InputView {
    fun enterPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid purchase.")
    }

    fun enterWinningNumbers() : List<Int> {
        return listOf()
    }
}
