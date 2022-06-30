package lotto.domain

import lotto.Const.ErrorMsg.INPUT_VALUE_IS_NOT_INT_ERROR_MSG

class Money(
    private val money: Int
) {
    constructor(value: String) : this(requireNotNull(value.toIntOrNull()) { INPUT_VALUE_IS_NOT_INT_ERROR_MSG })

    init {
        require(money >= 0) { "0이상이 아닌 값이 들어있습니다." }
    }

    operator fun div(other: Int): Int = money / other

    operator fun compareTo(other: Int): Int = money.compareTo(other)

    operator fun times(other: Int): Int = money * other
}
