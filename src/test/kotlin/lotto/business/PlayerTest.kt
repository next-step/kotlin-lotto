package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun `플레이어는 로또 티켓을 구매할 수 있다`() {
        // given
        val player = Player()
        val ticket = lottoTicket()

        // when
        player.addTickets(listOf(ticket))

        // then
        assertThat(player.tickets).containsExactly(ticket)
    }

    @Test
    fun `플레이어는 로또 티켓 리스트로 구매할 수 있다`() {
        // given
        val player = Player()
        val tickets = lottoTickets()

        // when
        player.addTickets(tickets)

        // then
        assertThat(player.tickets).containsAll(tickets)
    }

    private fun lottoTicket() = LottoTicket(
        setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
    )

    private fun lottoTickets() = listOf(
        LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        ),
        LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7)
            )
        ),
        LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(8)
            )
        )
    )
}
