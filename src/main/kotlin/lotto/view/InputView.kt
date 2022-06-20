package lotto.view

object InputView {
    const val GET_PRICE_MSG = "구입금액을 입력해 주세요."
    const val LOTTO_NUM_MSG = "지난 주 당첨 번호를 입력해 주세요."
    const val BONUS_NUM_MSG = "보너스 볼을 입력해 주세요."

    const val INPUT_VALUE_IS_NULL_ERROR_MSG = "입력한 값이 비어있습니다."
    const val INPUT_VALUE_IS_NOT_INT_ERROR_MSG = "입력한 값이 정수가 아닙니다."
    const val CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG = "로또 번호가 아닙니다."
    fun getPrice(): Int {
        val inputStr = printMsgAndReadValue(GET_PRICE_MSG)
        require(!inputStr.isNullOrBlank()) { INPUT_VALUE_IS_NULL_ERROR_MSG }
        return requireNotNull(inputStr.toIntOrNull()) { INPUT_VALUE_IS_NOT_INT_ERROR_MSG }
    }

    fun getLastWinningNumbers(): List<Int> {
        val inputStr = printMsgAndReadValue("\n$LOTTO_NUM_MSG")
        requireNotNull(inputStr) { INPUT_VALUE_IS_NULL_ERROR_MSG }
        return inputStr.split(",").map {
            requireNotNull(it.trim().toIntOrNull()) { CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
        }
    }

    fun getBonusNumber(): Int {
        val inputStr = printMsgAndReadValue("\n$BONUS_NUM_MSG")
        requireNotNull(inputStr) { INPUT_VALUE_IS_NULL_ERROR_MSG }
        return requireNotNull(inputStr.trim().toIntOrNull()) { CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
    }

    private fun printMsgAndReadValue(message: String): String? {
        println(message)
        return readlnOrNull()
    }
}
