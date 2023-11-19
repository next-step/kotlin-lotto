package lotto.view

object InputView {
    private const val PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요."
    private const val MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val MANUAL_LOTTO_ERROR_MESSAGE = "수동 구매 로또 수에 대해 숫자를 입력해 주세요"
    private const val MANUAL_LOTTO_NUMBERS_QUESTION = "수동으로 구매할 번호를 입력해 주세요."
    private const val WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요."

    fun getPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_QUESTION)
        return readInput()
    }

    fun getManualLottoNumbers() : List<String>? {
        println()
        println(MANUAL_LOTTO_COUNT_QUESTION)
        val count = readInput().toIntOrNull()
        if (count == null) {
            println(MANUAL_LOTTO_ERROR_MESSAGE)
            return null
        }
        println()
        println(MANUAL_LOTTO_NUMBERS_QUESTION)
        return List(count) { readInput() }
    }

    fun getWinningNumbersInput(): String {
        println(WINNING_NUMBERS_QUESTION)
        return readInput()
    }

    fun getBonusNumberInput(): String {
        println(BONUS_NUMBER_QUESTION)
        return readInput()
    }

    private fun readInput(): String = readlnOrNull()
        ?: throw IllegalArgumentException("입력 값이 없습니다.")
}
