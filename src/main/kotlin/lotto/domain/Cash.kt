package lotto.domain

import lotto.argumentError
import lotto.unsupportedError

data class Cash(
    private val value: Int
) {

    init {
        check(value >= 0) { argumentError("현금은 0원 아래일 수 없습니다.") }
    }

    override fun toString(): String {
        return "$value"
    }

    fun buy(price: Int): Pair<Cash, Int> {
        val count = value / price
        check(count > 0) {
            unsupportedError("최소 한 장이상의 티켓을 구매할 수 있는 금액이어야합니다.")
        }
        return Cash(value % price) to count
    }

    fun subtract(cash: Cash): Cash {
        return Cash(value - cash.value)
    }

    fun divide(cash: Cash): Int {
        return value / cash.value
    }
}
