package lotto.domain

import lotto.constants.ErrorMessages

/**
 * 소지금을 저장하는 클래스
 * Created by Jaesungchi on 2022.06.08..
 */
@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= 0) { ErrorMessages.MANUAL_LOTTO_COUNT_IS_OVER_MONEY }
    }

    operator fun minus(value: Int): Money {
        return Money(this.value - value)
    }

    operator fun div(value: Int): Int {
        return this.value / value
    }
}
