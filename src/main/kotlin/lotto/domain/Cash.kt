package lotto.domain

import lotto.argumentError
import lotto.unsupportedError

data class Cash(
    private val value: Int
) {

    init {
        check(value >= 0) { argumentError("현금은 0원 아래일 수 없습니다.") }
        require(value % LOTTO_PRICE == 0) { "잔액 없이 입력해야합니다 단위:$LOTTO_PRICE" }
    }

    override fun toString(): String {
        return "$value"
    }

    fun getAmount() = value

    fun buy(price: Int): Int {
        val count = value / price
        check(count > 0) {
            unsupportedError("최소 한 장이상의 티켓을 구매할 수 있는 금액이어야합니다.")
        }
        return count
    }

    fun subtract(cash: Cash): Cash {
        return Cash(value - cash.value)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
