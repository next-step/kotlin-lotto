package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {
    @Test
    fun `티켓에는 6개의 로또번호만 가지고있어야 한다`() {
        val ticket1 = LottoTicket.create()
        val ticket2 = LottoTicket.create()
        val ticket3 = LottoTicket.create()

        assertThat(ticket1.lotto.numbers.size).isEqualTo(6)
        assertThat(ticket2.lotto.numbers.size).isEqualTo(6)
        assertThat(ticket3.lotto.numbers.size).isEqualTo(6)
    }
}
