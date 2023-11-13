package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun `플래이어는 로또를 구매할 수 있다`() {
        // given
        val player = Player(purchasableCount = 5)
        val ticket = LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        // when
        player.addTicket(ticket)

        // then
        assertThat(player.tickets).containsExactly(ticket)
        assertThat(player.purchasableCount).isEqualTo(4)
    }
}
