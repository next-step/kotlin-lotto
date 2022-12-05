package lotto.domain

import fixture.WinningTicketFixture.winningTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class LottoTicketsTest {
    @Test
    internal fun `로또 티켓의 수가 반환된다`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 10, 11, 12),
                LottoTicket(1, 2, 3, 4, 11, 12)
            )
        )

        // when, then
        assertThat(lottoTickets.count()).isEqualTo(2)
    }

    @Test
    internal fun `로또 티켓이 합쳐진 값이 반환된다`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 10, 11, 12)
            )
        )
        val addLottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 6, 10, 12)
            )
        )

        // when
        val addLottoTicket = lottoTickets.addAll(addLottoTickets)

        // then
        assertThat(addLottoTicket.count()).isEqualTo(2)
    }
}
