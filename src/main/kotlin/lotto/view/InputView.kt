package lotto.view

object InputView {
    fun requestPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input =
            readlnOrNull()
                ?: throw IllegalArgumentException("No amount to purchase.")

        return input.toInt()
    }

    fun requestWinningNumbers(): List<Int> {
        println("Please enter last week’s winning numbers.")
        val input =
            readlnOrNull()
                ?: throw IllegalArgumentException("No numbers were entered.")

        return input.split(',')
            .filter { it.isNotBlank() }
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("Must only enter numbers.") }
    }

    fun requestBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input =
            readlnOrNull()
                ?: throw IllegalArgumentException("No numbers were entered.")

        return input.toIntOrNull() ?: throw IllegalArgumentException("Must only enter one number.")
    }
}
