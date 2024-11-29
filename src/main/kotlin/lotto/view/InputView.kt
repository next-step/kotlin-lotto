package lotto.view

object InputView {
    private const val MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."

    fun inputPurchaseAmount(): Int {
        println(MESSAGE_INPUT_PURCHASE_AMOUNT)
        return requireNotNull(readln().toIntOrNull())
    }
}
