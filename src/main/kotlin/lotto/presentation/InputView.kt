package lotto.presentation

object InputView {
    fun inputPurchaseAmount(): String {
        println(GUIDE_INPUT_PURCHASE_AMOUNT)
        val purchaseAmount = readlnOrNull()
        require(purchaseAmount != null)
        return purchaseAmount
    }

    fun inputWinningNumbers(): String {
        println(GUIDE_INPUT_LAST_WINNING_NUMBER)
        val winningNumber = readlnOrNull()
        require(winningNumber != null)
        return winningNumber
    }

    private const val GUIDE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val GUIDE_INPUT_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
}
