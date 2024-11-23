package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.domain.WinningLottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `당첨 티켓과 로또 티켓을 비교하여 당첨 결과를 반환한다`() {
        // given
        val winningLottoTicket =
            WinningLottoTicket.of(
                winningNumbers = setOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 7,
            )

        val lottoTickets =
            LottoTickets.of(
                money = 6_000,
                manualLottoCount = 6,
                manualNumbers =
                    listOf(
                        setOf(1, 2, 3, 4, 5, 6),
                        setOf(1, 2, 3, 4, 5, 7),
                        setOf(1, 2, 3, 4, 5, 8),
                        setOf(1, 2, 3, 4, 8, 9),
                        setOf(1, 2, 3, 10, 11, 12),
                        setOf(25, 26, 27, 28, 29, 30),
                    ),
            )

        // when
        val lottoResult = LottoResult.getResult(winningLottoTicket, lottoTickets)

        // then
        assertThat(lottoResult.rankInfo[Rank.FIRST]).isEqualTo(1)
        assertThat(lottoResult.rankInfo[Rank.SECOND]).isEqualTo(1)
        assertThat(lottoResult.rankInfo[Rank.THIRD]).isEqualTo(1)
        assertThat(lottoResult.rankInfo[Rank.FOURTH]).isEqualTo(1)
        assertThat(lottoResult.rankInfo[Rank.FIFTH]).isEqualTo(1)
        assertThat(lottoResult.rankInfo[Rank.NONE]).isEqualTo(1)
        assertThat(lottoResult.profitRate).isEqualTo(338592.5)
        assertThat(lottoResult.isProfit).isTrue()
    }
}
