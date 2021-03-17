package lotto.ticket

import lotto.result.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {

    @Test
    fun `당첨 번호와 로또를 맞춰 당첨 상금을 지급받는다`() {
        // given
        val winningTicket = WinningTicket.ofTxNumbers("1,2,3,4,5,6")
        val lottoTicket = LottoTicket(ManualDrawPolicy("1, 2, 3, 15, 11, 12"))

        // when
        // then
        assertThat(lottoTicket.match(winningTicket)).isEqualTo(Rank.FOURTH)
    }
}
