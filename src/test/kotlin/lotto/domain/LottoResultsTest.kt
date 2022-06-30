package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal
import java.math.RoundingMode

internal class LottoResultsTest {

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
            LottoResult(LottoPrize.FOURTH, PositiveNumber(1)),
            LottoResult(LottoPrize.FIFTH, PositiveNumber(2))
        ).toLottoResults()
        val result = lottoResult.rateOfResult(Money(price))
        assertThat(result).isEqualTo(expected.setScale(2, RoundingMode.HALF_UP))
    }

    @Test
    internal fun `등수에 일치하는 로또티켓의 개수 반환`() {
        val lottoResult = listOf(
            LottoResult(LottoPrize.FOURTH, PositiveNumber(1)),
            LottoResult(LottoPrize.FIFTH, PositiveNumber(2)),
            LottoResult(LottoPrize.SECOND, PositiveNumber(1))
        ).toLottoResults()

        assertThat(lottoResult.winningLottoCount(LottoPrize.FIRST)).isEqualTo(0)
        assertThat(lottoResult.winningLottoCount(LottoPrize.SECOND)).isEqualTo(1)
        assertThat(lottoResult.winningLottoCount(LottoPrize.THIRD)).isEqualTo(0)
        assertThat(lottoResult.winningLottoCount(LottoPrize.FOURTH)).isEqualTo(1)
        assertThat(lottoResult.winningLottoCount(LottoPrize.FIFTH)).isEqualTo(2)
    }
}
