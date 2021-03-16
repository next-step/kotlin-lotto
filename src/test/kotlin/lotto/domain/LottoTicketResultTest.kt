package lotto.domain

import lotto.supportdata.WinNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class LottoTicketResultTest {

    @Test
    @DisplayName("유저의 티켓정보와, 당첨번호를 넣으면 해당 유저의 당첨결과가 나온다")
    fun getLottoRank() {
        val userTicket = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6))
        val winNumber = WinNumber("1,2,3,4,10,11")
        val lottoTicketResult = LottoTicketResult(userTicket, winNumber)
        assertThat(lottoTicketResult.lottoRank).isEqualTo(LottoRank.THIRD)
    }
}
