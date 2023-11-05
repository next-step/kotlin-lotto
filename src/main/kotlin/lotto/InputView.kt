package lotto

class InputView {
    fun getPurchaseAmount(): Int {
        println(PURCHASE_AMOUNT_MESSAGE)
        return readln().toInt()
    }

    companion object {
       private const val PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    }
}
