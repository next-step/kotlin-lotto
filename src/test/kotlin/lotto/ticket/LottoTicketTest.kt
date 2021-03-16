package lotto.ticket

import lotto.result.PrizeRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {

    @Test
    fun `당첨 번호와 로또를 맞춰 당첨 상금을 지급받는다`() {
        //given
        val winningTicket = WinningTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        val lottoTicket = LottoTicket(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(10),
                LottoNumber(11),
                LottoNumber(12)
            )
        )

        //when
        //then
        assertThat(lottoTicket.match(winningTicket)).isEqualTo(PrizeRank.FOURTH)
    }

}