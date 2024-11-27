package lotto.view

class InputView {
    fun inputPurchaseAmount(): Int {
        println(PURCHASE_INFORMATION_MESSAGE)
        val input = readInput()
        return input
    }

    private fun readInput(): Int {
        return readln().toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER)
    }

    companion object {
        private const val PURCHASE_INFORMATION_MESSAGE = "구입금액을 입력해 주세요."
        private const val ERROR_INVALID_NUMBER = "유효한 숫자를 입력해주세요."
    }
}
