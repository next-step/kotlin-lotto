package lotto.view

import lotto.Const
import lotto.domain.LottoNumber

class InputView {
    fun getPrice(): Int {
        val inputStr = printMsgAndReadValue(Const.OutputMsg.GET_PRICE_MSG)
        require(!inputStr.isNullOrBlank()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
        return requireNotNull(inputStr.toIntOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NOT_INT_ERROR_MSG }
    }

    fun getLastWinningNumbers(): List<Int> {
        val inputStr = printMsgAndReadValue("\n${Const.OutputMsg.LOTTO_NUM_MSG}")
        requireNotNull(inputStr) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
        return inputStr.split(",").map {
            requireNotNull(it.trim().toIntOrNull()) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
        }
    }

    fun getBonusNumber(): LottoNumber {
        val inputStr = printMsgAndReadValue("\n${Const.OutputMsg.BONUS_NUM_MSG}")
        requireNotNull(inputStr) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
        val number = requireNotNull(inputStr.trim().toIntOrNull()) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
        return LottoNumber(number)
    }

    private fun printMsgAndReadValue(message: String): String? {
        println(message)
        return readlnOrNull()
    }
}
