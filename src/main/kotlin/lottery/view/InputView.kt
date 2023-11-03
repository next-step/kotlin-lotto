package lottery.view

object InputView {
    private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요."

    fun inputAmount(): String {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return readln()
    }
}
