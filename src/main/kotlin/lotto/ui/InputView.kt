package lotto.ui

class InputView {
    fun readPayment(): Int {
        println(PAYMENT_TEXT)
        return readln().toInt()
    }

    fun readLastNumber(): String {
        println(LAST_NUMBER_TEXT)
        return readln()
    }

    companion object {
        private const val PAYMENT_TEXT = "구입금액을 입력해 주세요."
        private const val LAST_NUMBER_TEXT = "\n지난 주 당첨 번호를 입력해 주세요."
    }
}
