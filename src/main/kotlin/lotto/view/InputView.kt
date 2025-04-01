package lotto.view

class InputView {

    companion object {
        fun readPurchaseAmount(): Int {
            println("Please enter the purchase amount.")
            return readlnOrNull()?.toIntOrNull()
                ?.takeIf { it >= 1000 }
                ?: throw IllegalArgumentException("Invalid amount. Must be at least 1,000 KRW.")
        }

        fun readWinningNumbers(): List<Int> {
            println("Please enter last week’s winning numbers.")
            return readlnOrNull()
                ?.split(",")
                ?.map { it.trim().toInt() }
                ?.toList()
                ?.takeIf { it.size == 6 }
                ?: throw IllegalArgumentException("Invalid input. Must enter exactly 6 unique numbers.")
        }
    }
}