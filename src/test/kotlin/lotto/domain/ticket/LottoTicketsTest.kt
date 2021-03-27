package lotto.domain.ticket

import lotto.domain.LottoNumber
import lotto.domain.result.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketsTest {
    @Test
    fun `로또 티켓 뭉치와 우승 티켓을 비교하여 결과를 산출한다`() {
        // given
        val expectResult = LottoResult(
            listOf(
                WinningBoard.SIX,
                WinningBoard.THREE
            )
        )
        val bonusNumber = LottoNumber.of(20)

        val winningLottoTicket = WinningLottoTicket(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
            )
        )

        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket.AutomaticLottoTicket(
                    setOf(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                    )
                ),
                LottoTicket.AutomaticLottoTicket(
                    setOf(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(43),
                        LottoNumber.of(44),
                        LottoNumber.of(45)
                    )
                )
            )
        )

        // when
        val result = lottoTickets.compare(WinningLotto(winningLottoTicket, bonusNumber))

        // then
        assertThat(result).isEqualTo(expectResult)
    }
}
