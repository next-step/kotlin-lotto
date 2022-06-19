package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal
import java.math.RoundingMode

internal class LottoScoreTest {
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

        val lottoResults = LottoScore().compareNumber(winningLotto, lottoTickets)
        val expected = mapOf(
            LottoPrize.FIRST to 1,
            LottoPrize.SECOND to 1,
            LottoPrize.THIRD to 2,
            LottoPrize.FOURTH to 1,
            LottoPrize.FIFTH to 2
        )

        assertThat(lottoResults).hasSize(expected.size)
        assertAll(
            {
                expected.forEach { (prize, lottoCount) ->
                    val lottoResult = lottoResults.find { it.lottoPrize == prize }
                    assertThat(lottoResult?.lottoCount).isEqualTo(lottoCount)
                }
            }
        )
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "5000, 12",
            "60000, 1",
            "60500, 1",
            "120000, 0.5",
            "210000, 0.285"
        ]
    )
    internal fun `당첨 결과에 따라 수익률을 반환한다`(price: Int, expected: BigDecimal) {
        // 총 상금: 60,000
        val lottoResult = listOf(
            LottoResult(LottoPrize.FOURTH, 1),
            LottoResult(LottoPrize.FIFTH, 2)
        )
        val result = LottoScore().rateOfResult(LottoPrice(price), lottoResult)
        assertThat(result).isEqualTo(expected.setScale(2, RoundingMode.HALF_UP))
    }

    private fun LottoTicket(vararg numbers: Int) =
        LottoTicket(numbers.map { LottoNumber(it) }.toSet())
}
