package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `티켓을 주면 등수를 리턴해준다`() {
        val winLottoTicket = LottoTicketMachine.issue(listOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicketMachine.issue(listOf(1, 2, 7, 9, 8, 16))

        val determineLottoTicket = Rank.determineLottoTicket(winLottoTicket, lottoTicket)

        assertThat(determineLottoTicket).isEqualTo(Rank.FAIL)
    }
}
