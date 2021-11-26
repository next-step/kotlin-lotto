package lotto.validation

import lotto.constant.Const
import lotto.constant.Message

object InputValidation {
    private const val MAX_LOTTO_NUMBER_COUNT = 6
    private val LOTTO_NUMBER_RANGE = 1..45

    fun checkAmountPaid(input: String) {
        require(input.toIntOrNull() != null) { IllegalArgumentException(Message.ILLEGAL_AMOUNT_MESSAGE) }
    }

    fun checkWinningNumber(input: String) {
        val list = input.split(Const.LOTTO_NUMBER_DELIMITER)
        require(list.size == MAX_LOTTO_NUMBER_COUNT) { IllegalArgumentException(Message.ILLEGAL_NUMBER_MESSAGE) }
        list.forEach {
            require(it.toIntOrNull() != null) { IllegalArgumentException(Message.ILLEGAL_NUMBER_MESSAGE) }
            require(LOTTO_NUMBER_RANGE.contains(it.toInt())) { IllegalArgumentException(Message.ILLEGAL_NUMBER_MESSAGE) }
        }
    }
}
