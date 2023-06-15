package lotto.view

class LottoPurchasePriceInputView : InputView<Int>() {
    override val message: String = "구입금액을 입력해 주세요."
    override val value: Int

    override fun readValue(): Int {
        return readln().toInt()
    }

    init {
        renderMessage()
        value = readValue()
    }
}
