package lotto.io

object InputView {
    private const val AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요."
    private const val WIN_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_ERROR_MESSAGE = "입력이 올바르지 않습니다"
    private const val INPUT_DELIMITER = ", "

    fun getAmount(): Int {
        println(AMOUNT_INPUT_MESSAGE)
        return requireNotNull(readlnOrNull()?.toIntOrNull()) { INPUT_ERROR_MESSAGE }
    }

    fun getWinNumbers(): List<Int> {
        println(WIN_NUMBER_INPUT_MESSAGE)
        val tokens = requireNotNull(readlnOrNull()?.split(INPUT_DELIMITER)) { INPUT_ERROR_MESSAGE }
        return tokens.map { requireNotNull(it.toIntOrNull()) { INPUT_ERROR_MESSAGE } }
    }
}
