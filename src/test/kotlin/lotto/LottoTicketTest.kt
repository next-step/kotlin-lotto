package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTicketTest {
    @Test
    fun `돈으로 티캣을 생성한다`() {
        assertThat(LottoTicket(Money(14_000)).count).isEqualTo(14)
    }

    @Test
    fun `0으로 나눌 수 없다`() {
        assertThrows<IllegalArgumentException> { Quotient(Money(1_000), 0) }
    }

    @Test
    fun `나머지를 제외한 몫만 제공한다`() {
        assertThat(Quotient(Money(1_500), 1_000).int).isEqualTo(1)
    }

    class LottoTicket(val count: Int) {
        constructor(money: Money) : this(Quotient(money, TICKET_AMOUNT).int)

        companion object {
            val TICKET_AMOUNT = Money(1_000)
        }
    }

    data class Money(val amount: Int)

    class Quotient(private val dividend: Int, private val divisor: Int) {
        val int: Int
            get() = dividend / divisor

        init {
            require(divisor != 0)
        }

        constructor(dividend: Money, divisor: Int) : this(dividend.amount, divisor)
        constructor(dividend: Money, divisor: Money) : this(dividend.amount, divisor.amount)
    }
}
