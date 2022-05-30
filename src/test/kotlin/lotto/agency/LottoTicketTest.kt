package lotto.agency

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `구매한 로또 티켓과 당첨 티켓의 숫자 일치 갯수 확인`() {
        val purchasedLottoTicket = LottoTicket(
            numbers = setOf(1, 2, 3, 4, 5, 6)
        )
        val wonLottoTicket = LottoTicket(
            numbers = setOf(1, 2, 3, 4, 5, 6)
        )

        assertThat(purchasedLottoTicket.countMatchWonLottoTicket(wonLottoTicket)).isEqualTo(6)
    }
}
