package lotto.presentation

object InputView {
    fun inputPurchaseAmount(): String? {
        println(GUIDE_INPUT_PURCHASE_AMOUNT)
        val purchaseAmount = readlnOrNull()
        return purchaseAmount
    }

    fun inputWinningNumber(): String? {
        println(GUIDE_INPUT_LAST_WINNING_NUMBER)
        val winningNumber = readlnOrNull()
        return winningNumber
    }

    private const val GUIDE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val GUIDE_INPUT_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
}
