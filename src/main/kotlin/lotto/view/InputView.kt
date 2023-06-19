package lotto.view

class InputView {

    fun inputPurchaseAmount():Int {
        println("구입금액을 입력해 주세요.")
        var inputAmount = readNumber()
        while (!isValid(inputAmount)) {
            println("구입금액은 0보다 크고 100만보다 작거나 같아야 합니다. 다시 입력해주세요.")
            inputAmount = readNumber()
        }
        return inputAmount
    }

    private fun readNumber(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }

    private fun isValid(number: Int): Boolean {
        if (number in PURCHASABLE_RANGE) return true
        return false
    }

    companion object {
        private val PURCHASABLE_RANGE = 1..1000000
    }
}