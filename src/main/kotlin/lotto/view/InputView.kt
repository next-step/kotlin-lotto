package lotto.view

class InputView {
    fun getPurchaseAmount(): Double {
        println(GUIDE_PURCHASE_AMOUNT)
        return readln().toDouble()
    }

    fun getWinningNumbers(): List<Int> {
        println(GUIDE_WINNING_NUMBER)
        val numbers = readln().split(",")
        return numbers.map { it.trim().toInt() }
    }

    companion object {
        private const val GUIDE_PURCHASE_AMOUNT = "Please enter the purchase amount."
        private const val GUIDE_WINNING_NUMBER = "Please enter last week's winning numbers"
    }
}
