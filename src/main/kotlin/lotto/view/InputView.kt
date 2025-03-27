package lotto.view

object InputView {
    fun requestPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input =
            readlnOrNull()
                ?: throw IllegalArgumentException("No amount to purchase.")

        return input.toInt()
    }
}
