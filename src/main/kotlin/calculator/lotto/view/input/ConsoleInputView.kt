package calculator.lotto.view.input

class ConsoleInputView : InputView {
    override fun getPurchaseAmount() {
        println(RECEIVE_PURCHASE_AMOUNT_MESSAGE)
    }

    override fun getWonNumbers() {
        println(RECEIVE_WON_NUMBERS_MESSAGE)
    }

    companion object {
        private const val RECEIVE_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val RECEIVE_WON_NUMBERS_MESSAGE = "지난 주 당첨번호를 입력해 주세요."
    }
}
