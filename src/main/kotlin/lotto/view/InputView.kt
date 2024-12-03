package lotto.view

class InputView {
    fun getPurchasAmountInput() = getIntput(PURCHASE_AMOUNT) ?: throw RuntimeException("금액을 입력되지 않았습니다.")

    fun getWinningNumberInput() = getIntput(WINNING_NUMBER) ?: throw RuntimeException("우승 번호가 입력되지 않았습니다.")

    private fun getIntput(message: String): String? {
        println(message)
        val input = readlnOrNull()?.trim()
        if (input.isNullOrEmpty()) return null
        return input
    }

    private companion object {
        const val PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    }
}
