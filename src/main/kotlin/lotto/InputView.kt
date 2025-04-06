package lotto

class InputView {
    fun enterPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid purchase.")
    }
}
