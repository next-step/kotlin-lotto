package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoTicketTest {
    @Test
    fun `돈으로 티캣을 생성한다`() {
        assertThat(LottoTicket(Money(14_000)).count()).isEqualTo(14)
    }

    @Test
    fun `0으로 나눌 수 없다`() {
        assertThrows<IllegalArgumentException> { Quotient(Money(1_000), 0) }
    }

    class LottoTicket(private val money: Money) {
        fun count(): Int = Quotient(money, 1000).int
    }

    data class Money(val amount: Int)

    class Quotient(private val dividend: Int, private val divisor: Int) {
        val int: Int
            get() = dividend / divisor

        init {
            require(divisor != 0)
        }

        constructor(dividend: Money, divisor: Int) : this(dividend.amount, divisor)
    }
}
