package lotto.agency

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `구매한 로또 티켓과 당첨 티켓의 숫자 일치 갯수 확인`() {
        val purchasedLottoTicket = LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val wonLottoTicket = LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        assertThat(purchasedLottoTicket.countMatchWonLottoTicket(wonLottoTicket)).isEqualTo(6)
    }
}
