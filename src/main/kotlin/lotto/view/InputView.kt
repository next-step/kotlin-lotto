package lotto.view

import lotto.Const

class InputView {
    fun getPrice(): String? = printMsgAndReadValue(Const.OutputMsg.GET_PRICE_MSG)

    fun getLastWinningNumbers(): List<Int> {
        val inputStr = printMsgAndReadValue("\n${Const.OutputMsg.LOTTO_NUM_MSG}")
        requireNotNull(inputStr) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
        return inputStr.split(",").map {
            requireNotNull(it.trim().toIntOrNull()) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
        }
    }

    private fun printMsgAndReadValue(message: String): String? {
        println(message)
        return readlnOrNull()
    }
}
