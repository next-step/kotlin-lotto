package domain.statistics

import domain.lotto.Lotto
import domain.lotto.Lottos
import domain.lotto.lottoNumberOf
import domain.lotto.lottoOf
import domain.money.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningStatisticsTest {
    @Test
    fun `당첨통계는 당첨로또숫자열과 로또 리스트와 로또 하나의 가격으로 생성된다`() {
        assertDoesNotThrow {
            WinningStatistics(
                winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
                lottos = Lottos(listOf(lottoOf(1, 2, 3, 4, 5, 6)))
            )
        }
    }

    @ParameterizedTest(name = "{0}원짜리 로또 {1}개가 모두 3개일치 로또라면 {2}의 수익률을 반환해야 한다")
    @CsvSource(
        "1000, 2, 5.0",
        "1000, 5, 5.0",
        "2000, 5, 2.5"
    )
    fun `당첨통계는 수익률을 반환한다`(lottoPriceValue: Long, lottoCount: Int, expectedRatio: Double) {
        val lottos = Lottos(List(lottoCount) { Lotto(lottoNumberOf(1, 2, 3, 43, 44, 45)) })
        val statistics = WinningStatistics(
            winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottos = lottos
        )
        val expected = IncomeExpenditureRatio(expectedRatio)

        val actual = statistics.calculateRatioOfIncomeToExpenditure(Money(lottoPriceValue))

        assertThat(actual).isEqualTo(expected)
    }
}
