package lotto.validation

import lotto.constant.Const
import lotto.constant.Message
import lotto.domain.Lotto
import kotlin.IllegalArgumentException

object InputValidation {
    private const val MAX_LOTTO_NUMBER_COUNT = 6

    fun checkAmountPaid(input: String) {
        require(input.toIntOrNull() != null) { IllegalArgumentException(Message.ILLEGAL_AMOUNT_MESSAGE) }
    }

    fun checkWinningNumber(input: String) {
        val list = input.split(Const.LOTTO_NUMBER_DELIMITER)
        require(list.size == MAX_LOTTO_NUMBER_COUNT) { IllegalArgumentException(Message.ILLEGAL_NUMBER_MESSAGE) }
        list.forEach {
            require(it.toIntOrNull() != null) { IllegalArgumentException(Message.ILLEGAL_NUMBER_MESSAGE) }
            require(Lotto.allNumber.contains(it.toInt())) { IllegalArgumentException(Message.ILLEGAL_NUMBER_MESSAGE) }
        }
    }
}
