package lotto.domain

import lotto.domain.LottoTicket
import lotto.domain.Money
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
        assertThrows<IllegalArgumentException> { Money(1_000) / Money(0) }
    }

    @Test
    fun `나머지를 제외한 몫만 제공한다`() {
        assertThat(Money(1_500) / Money(1_000)).isEqualTo(1)
    }
}
