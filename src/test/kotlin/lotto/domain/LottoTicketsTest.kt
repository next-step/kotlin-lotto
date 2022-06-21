package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LottoTicketsTest {
    @Test
    internal fun `당첨 번호와 나의 로또 번호를 비교하여 결과를 반환한다`() {
        val lottoTickets = listOf(
            LottoTicket(1, 2, 3, 8, 9, 10), // 3match
            LottoTicket(1, 2, 5, 10, 11, 12), // 3match
            LottoTicket(1, 2, 3, 4, 18, 17), // 4match
            LottoTicket(1, 2, 3, 5, 6, 19), // 5match
            LottoTicket(1, 2, 3, 4, 5, 23), // 5match
            LottoTicket(1, 2, 3, 4, 5, 7), // 5match - bonus
            LottoTicket(1, 2, 3, 4, 5, 6), // 6match
        )

        val winningLotto = WinningLotto(
            LottoTicket(1, 2, 3, 4, 5, 6),
            LottoNumber(7)
        )

        val lottoResults = LottoTickets(lottoTickets).compareNumber(winningLotto)
        val expected = mapOf(
            LottoPrize.FIRST to 1,
            LottoPrize.SECOND to 1,
            LottoPrize.THIRD to 2,
            LottoPrize.FOURTH to 1,
            LottoPrize.FIFTH to 2
        )

        assertThat(lottoResults.get()).hasSize(expected.size)
        assertAll(
            {
                expected.forEach { (prize, lottoCount) ->
                    val lottoResult = lottoResults.get().find { it.lottoPrize == prize }
                    assertThat(lottoResult?.matchedLottoCount?.toInt()).isEqualTo(lottoCount)
                }
            }
        )
    }

    private fun LottoTicket(vararg numbers: Int) =
        LottoTicket(numbers.map { LottoNumber(it) }.toSet())
}
