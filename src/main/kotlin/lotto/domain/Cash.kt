package lotto.domain

import lotto.argumentError
import lotto.unsupportedError

data class Cash(
    private val value: Int
) {
    constructor(input: String) : this(
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            error("현금은 숫자여야합니다.")
        }
    )

    init {
        check(value >= 0) { argumentError("현금은 0원 아래일 수 없습니다.") }
    }

    override fun toString(): String {
        return "${value}원"
    }

    fun buyTickets(): Pair<Cash, LottoUnusedTickets> {
        val ticketCount = value / TICKET_PRICE

        check(ticketCount > 0) {
            unsupportedError("최소 한 장이상의 티켓을 구매할 수 있는 금액이어야합니다.")
        }
        return Cash(value % TICKET_PRICE) to LottoUnusedTickets.from(ticketCount)
    }

    fun subtract(cash: Cash): Cash {
        return Cash(value - cash.value)
    }

    fun divide(cash: Cash): Int {
        return value / cash.value
    }

    companion object {
        private const val TICKET_PRICE = 1000
    }
}
