package lotto.ticket

import lotto.result.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IssuedLottoTicketsTest {

    @Test
    fun `내가 발급받은 로또를 당첨번호와 맞춰 당첨금을 받는다`() {
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

        val lottoTickets = IssuedLottoTickets(
            listOf(
                LottoTicket(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(10),
                        LottoNumber(11),
                        LottoNumber(12)
                    )
                ),
                LottoTicket(
                    setOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(11),
                        LottoNumber(12)
                    )
                )
            )
        )

        //when
        val winningResult = lottoTickets.match(winningTicket)

        //then
        assertThat(winningResult.totalPrize).isEqualTo(Prize(55000))

    }
}