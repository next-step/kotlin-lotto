package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketDispenserTest {

    @Test
    fun `원하는 개수만큼의 티켓을 발급하는지 확인`() {
        // given
        val lottoTicketDispenser = LottoTicketDispenser(LottoTicketGenerator())
        val lottoTickets = lottoTicketDispenser.getAutoTickets(1_000 * 10)

        // then
        assertThat(lottoTickets.size()).isEqualTo(10)
    }
}
