package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun `플레이어는 로또 티켓을 구매할 수 있다`() {
        // given
        val player = Player(receivedAmount = ReceivedAmount(5_000))
        val ticket = lottoTicket()

        // when
        player.addTickets(listOf(ticket))

        // then
        assertThat(player.tickets).containsExactly(ticket)
        assertThat(player.purchasedCount).isEqualTo(5)
    }

    @Test
    fun `플레이어는 로또 티켓 리스트로 구매할 수 있다`() {
        // given
        val player = Player(receivedAmount = ReceivedAmount(5_000))
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

    @Test
    fun `플레이어는 구매 가능한 로또 개수보다 많은 로또들을 구매할 수 없다`() {
        // given
        val player = Player(receivedAmount = ReceivedAmount(1_000))
        val ticket = lottoTicket()

        // when , then
        assertThatThrownBy { player.addTickets(listOf(ticket, ticket)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("더 이상 로또를 구매할 수 없습니다.")
    }

    @Test
    fun `플레이어는 구매 가능한 로또 개수보다 많은 로또를 구매할 수 없다`() {
        // given
        val player = Player(receivedAmount = ReceivedAmount(1_000))
        val ticket = lottoTicket()
        player.addTickets(listOf(ticket))

        // when , then
        assertThatThrownBy { player.addTickets(listOf(ticket)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("더 이상 로또를 구매할 수 없습니다.")
    }

    @Test
    fun `플레이어의 구매 한 로또 개수를 알 수 있다`() {
        // given
        val player = Player(receivedAmount = ReceivedAmount(5_000))
        val ticket = lottoTicket()
        player.addTickets(listOf(ticket))

        // when , then
        assertThat(player.purchasableCount).isEqualTo(4)
    }

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
