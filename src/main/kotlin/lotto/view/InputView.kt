package lotto.view

class InputView {
    fun enterPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid purchase.")
    }

    fun enterWinningNumbers() : List<Int> {
        println("\nPlease enter last week’s winning numbers.")
        val input = readlnOrNull() ?: throw IllegalArgumentException("Please enter a valid numbers.")
        return input.split(",").map { it.trim().toIntOrNull()
            ?: throw IllegalArgumentException("Please enter a valid numbers.") }
    }

    fun enterBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readlnOrNull() ?: throw IllegalArgumentException("Please enter a valid number.")
        return input.toIntOrNull() ?: throw java.lang.IllegalArgumentException("Please enter a valid number.")
    }
}
