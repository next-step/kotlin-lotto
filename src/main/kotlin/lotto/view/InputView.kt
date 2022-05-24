package lotto.view

object InputView {
    private const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요"

    fun receiveUserInput() {
        printPurchaseAmountInputMessage()
    }

    private fun printPurchaseAmountInputMessage() {
        println(MESSAGE_INPUT_PURCHASE_AMOUNT)
    }
}
