package lotto.view

object InputView {
    fun requestPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return inputNumber()
    }

    fun requestWinningNumbers(): List<Int> {
        println("Please enter last week’s winning numbers.")
        return inputLottoNumbers()
    }

    fun requestBonusNumber(): Int {
        println("Please enter the bonus number.")
        return inputNumber()
    }

    fun requestManualLottoNumbers(): List<List<Int>> {
        println("Enter the number of manual tickets to purchase.")
        val numberOfTickets = inputNumber()
        println("Enter the numbers for manual tickets.")

        return List(numberOfTickets) { inputLottoNumbers() }
    }

    private fun inputNumber(): Int {
        val input =
            readlnOrNull()
                ?: throw IllegalArgumentException("No numbers were entered.")

        return input.toIntOrNull() ?: throw IllegalArgumentException("Must only enter one number.")
    }

    private fun inputLottoNumbers(): List<Int> {
        val input =
            readlnOrNull()
                ?: throw IllegalArgumentException("No numbers were entered.")

        return input.split(',')
            .filter { it.isNotBlank() }
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("Must only enter numbers.") }
    }
}
