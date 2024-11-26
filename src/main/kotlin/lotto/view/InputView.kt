package lotto.view

class InputView {
    fun readTotalPurchaseAmount() : String {
        val totalAmount = readlnOrNull()
        return totalAmount ?: "0"
    }
}