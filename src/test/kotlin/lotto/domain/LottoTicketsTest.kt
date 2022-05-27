package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `로또티켓중 당첨번호와 일치하는 리스트를 반환한다`() {

        val expect = listOf(
            MatchState.MATCH_6,
            MatchState.MATCH_6,
            MatchState.MATCH_5,
        )

        val lastWinTicket = LottoTicket(
            listOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(4), LottoNumber(5), LottoNumber(6)
            )
        )
        val lottoTicket1 = LottoTicket(
            listOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(4), LottoNumber(5), LottoNumber(6)
            )
        )
        val lottoTicket2 = LottoTicket(
            listOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(4), LottoNumber(5), LottoNumber(6)
            )
        )
        val lottoTicket3 = LottoTicket(
            listOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(4), LottoNumber(5), LottoNumber(7)
            )
        )

        val checker = Checker(lastWinTicket)
        val winList = LottoTickets(
            listOf(
                lottoTicket1,
                lottoTicket2,
                lottoTicket3
            )
        ).win(checker)

        assertThat(winList).isEqualTo(expect)
    }
}
