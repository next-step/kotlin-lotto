package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketDispenserTest {

    @Test
    fun `원하는 개수의 자동 티켓을 발급하는지 확인`() {
        // given
        val lottoTicketDispenser = LottoTicketDispenser(LottoTicketGenerator())
        val autoLottoTickets = lottoTicketDispenser.getAutoTickets(LottoMoney(1_000 * 10))

        // then
        assertThat(autoLottoTickets.size()).isEqualTo(10)
    }

    @Test
    fun `원하는 개수의 수동 티켓을 발급하는지 확인`() {
        // given
        val lottoTicketDispenser = LottoTicketDispenser(LottoTicketGenerator())
        val manualLottoTickets = lottoTicketDispenser.getManualTickets(
            listOf(
                intArrayOf(1, 2, 3, 4, 5, 6),
                intArrayOf(2, 3, 4, 5, 6, 7)
            )
        )

        // then
        assertThat(manualLottoTickets.size()).isEqualTo(2)
    }
}
