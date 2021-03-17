package lotto.ticket

import lotto.result.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IssuedLottoTicketsTest {

    @Test
    fun `내가 발급받은 로또를 당첨번호와 맞춰 당첨금을 받는다`() {
        val winningTicket = WinningTicket.ofTxNumbers("1,2,3,4,5,6")

        val lottoTickets = IssuedLottoTickets(
            listOf(
                LottoTicket(
                    ManualDrawPolicy("1,2,3,10,11,12")

                ),
                LottoTicket(
                    ManualDrawPolicy("1, 2, 3, 4, 11, 12")
                )
            )
        )

        // when
        val winningResult = lottoTickets.match(winningTicket)

        // then
        assertThat(winningResult.totalPrize).isEqualTo(Prize(55000))
    }
}
