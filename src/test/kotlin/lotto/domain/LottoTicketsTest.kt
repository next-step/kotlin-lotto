package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LottoTicketsTest {
    @Test
    fun `로또 티켓들과 행운 번호를 비교해 결과가 제대로 나오는지 확인`() {
        // given
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(1, 2, 3, 4, 5, 6)
            )
        )
        val luckyTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.of(7)
        val expectedLottoResults = LottoResults(
            mapOf(LottoResult.FIRST to 3)
        )

        // when
        val actualLottoResults = lottoTickets.compare(luckyTicket, bonusNumber)

        // then
        assertAll(
            { assertThat(actualLottoResults.getTotalPrize()).isEqualTo(expectedLottoResults.getTotalPrize()) },
            { assertThat(actualLottoResults.countOf(LottoResult.FIRST)).isEqualTo(3) }
        )
    }

    @Test
    fun `일급 컬렉션 끼리 덧셈연산이 제대로 되는지 확인`() {
        // given
        val lottoTickets1 = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(2, 3, 4, 5, 6, 7)
            )
        )
        val lottoTickets2 = LottoTickets(
            listOf(
                LottoTicket(4, 5, 6, 7, 8, 9)
            )
        )

        // when
        val combinedLottoTickets = lottoTickets1 + lottoTickets2

        // then
        assertThat(combinedLottoTickets.size()).isEqualTo(3)
    }
}
