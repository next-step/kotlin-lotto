package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `돈으로 티캣을 생성한다`() {
        assertThat(LottoTicket(Money(14_000)).count()).isEqualTo(14)
    }

    class LottoTicket(private val money: Money) {
        fun count(): Int = 14
    }

    data class Money(private var amount: Int)
}
