package lotto.view

class InputView {
    fun getPurchasAmountInput() = getIntput(PURCHASE_AMOUNT)

    fun getWinningNumberInput() = getIntput(WINNING_NUMBER)

    private fun getIntput(message: String): String {
        println(message)
        val input = readlnOrNull()?.trim()
        if (input.isNullOrEmpty()) throw RuntimeException("금액을 입력되지 않았습니다.")
        return input
    }

    private companion object {
        const val PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    }
}
