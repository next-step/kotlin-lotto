package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LottoScoreTest {
    @Test
    internal fun `당첨 번호와 나의 로또 번호를 비교하여 결과를 반환한다`() {
        val lottoTickets = listOf(
            LottoTicket(1, 2, 3, 8, 9, 10), // 3match
            LottoTicket(1, 2, 5, 10, 11, 12), // 3match
            LottoTicket(1, 2, 3, 4, 18, 17), // 4match
            LottoTicket(40, 1, 2, 3, 4, 5), // 5match
            LottoTicket(1, 2, 3, 4, 5, 6), // 6match
        )
        val winningTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        val lottoResults = LottoScore().compareNumber(winningTicket, lottoTickets)
        val expected = mapOf(
            LottoPrize.THREE_MATCH to 2,
            LottoPrize.FOUR_MATCH to 1,
            LottoPrize.FIVE_MATCH to 1,
            LottoPrize.SIX_MATCH to 1
        )

        assertThat(lottoResults.size).isEqualTo(expected.size)
        assertAll(
            {
                expected.forEach { (prize, lottoCount) ->
                    val lottoResult = lottoResults.find { it.lottoPrize == prize }
                    assertThat(lottoResult?.lottoCount).isEqualTo(lottoCount)
                }
            }
        )
    }

    private fun LottoTicket(vararg numbers: Int) =
        LottoTicket(numbers.map { LottoNumber(it) }.toSet())
}
