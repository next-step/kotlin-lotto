package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoTicketManagerTest {

    @Test
    fun `로또 티켓을 추가한다`() {
        // given
        val lottoTicketManager = LottoTicketManager()
        val ticket = LottoTicket(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        // when
        lottoTicketManager.add(ticket)

        // then
        assertAll(
            { assertThat(lottoTicketManager.tickets).hasSize(1) },
            { assertThat(lottoTicketManager.tickets[0]).isEqualTo(ticket) }
        )
    }

    @Test
    fun `로또 티켓 리스트를 추가한다`() {
        // given
        val lottoTicketManager = LottoTicketManager()
        val tickets = listOf(
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            ),
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )

        // when
        lottoTicketManager.addAll(tickets)

        // then
        assertAll(
            { assertThat(lottoTicketManager.tickets).hasSize(2) },
            { assertThat(lottoTicketManager.tickets[0]).isEqualTo(tickets[0]) },
            { assertThat(lottoTicketManager.tickets[1]).isEqualTo(tickets[1]) }
        )
    }

    @Test
    fun `당첨 번호와 비교하여 결과를 추출한다`() {
        // given
        val lottoTicketManager = LottoTicketManager()
        val tickets = listOf(
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            ),
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(7)
                )
            )
        )
        val winningNumbers = LottoWinningNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        lottoTicketManager.addAll(tickets)

        // when
        val results = lottoTicketManager.calculateResults(winningNumbers)

        // then
        assertAll(
            { assertThat(results).hasSize(2) },
            { assertThat(results[LotteryPrize.SIX_MATCH]).isEqualTo(1) },
            { assertThat(results[LotteryPrize.FIVE_MATCH]).isEqualTo(1) }
        )
    }
}
