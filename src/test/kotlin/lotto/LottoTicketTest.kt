package lotto

import lotto.agency.LottoNumber
import lotto.agency.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `로또 숫자가 로또 번호 범위 내에 있는지 확인`() {
        val oneLottoNumber = LottoNumber.getRandomOne()

        assertThat(oneLottoNumber)
            .isGreaterThanOrEqualTo(1)
            .isLessThanOrEqualTo(45)
    }

    @Test
    fun `구매한 로또 티켓과 당첨 티켓의 숫자 일치 갯수 확인`() {
        val purchasedLottoTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val wonLottoTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))

        assertThat(purchasedLottoTicket.countMatchWonLottoTicket(wonLottoTicket)).isEqualTo(6)
    }
}
