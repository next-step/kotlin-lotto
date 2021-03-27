package domain.statistics

import domain.lotto.Lotto
import domain.lotto.lottoNumberOf
import domain.lotto.lottoOf
import domain.money.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class WinningStatisticsTest {
    @Test
    fun `당첨통계는 당첨로또숫자열과 로또 리스트와 로또 하나의 가격으로 생성된다`() {
        assertDoesNotThrow {
            WinningStatistics(
                winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
                lottos = listOf(lottoOf(1, 2, 3, 4, 5, 6))
            )
        }
    }

    @ParameterizedTest(name = "{6}과 일치하는 로또의 개수를 구한다")
    @CsvSource(
        "1,2,3,4,5,6,SIX_CORRECT",
        "1,2,3,4,5,45,FIVE_CORRECT",
        "1,2,3,4,44,45,FOUR_CORRECT",
        "1,2,3,43,44,45,THREE_CORRECT"
    )
    fun countLottoByTest(
        n1: Int,
        n2: Int,
        n3: Int,
        n4: Int,
        n5: Int,
        n6: Int,
        category: WinningCategory
    ) {
        // given
        val statistics = WinningStatistics(
            winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottos = listOf(Lotto(lottoNumberOf(n1, n2, n3, n4, n5, n6)))
        )

        // when
        val actual = statistics.countLottoBy(category)

        // then
        assertThat(actual).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2])
    fun `총 로또 중 6개 모두 일치하는 로또의 개수를 구한다`(expectedCount: Int) {
        // given
        val winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)
        val sixCorrectLottos = (1..expectedCount).map { Lotto(winningNumbers) }
        val statistics = WinningStatistics(
            winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottos = sixCorrectLottos
        )

        // when
        val actual = statistics.countLottoBy(WinningCategory.SIX_CORRECT)

        // then
        assertThat(actual).isEqualTo(expectedCount)
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 3",
        "1000, 5",
        "2000, 5"
    )
    fun `당첨통계는 수익률을 반환한다`(lottoPriceValue: Long, lottoCount: Int) {
        val statistics = WinningStatistics(
            winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
            lottos = List(lottoCount) { Lotto(lottoNumberOf(1, 2, 3, 4, 5, 6)) }
        )

        val lottoPrice = Money(lottoPriceValue)

        assertThat(
            statistics.calculateRatioOfIncomeToExpenditure(lottoPrice)
        ).isEqualTo(
            IncomeExpenditureRatio.calculatedBy(
                income = statistics.totalWinningPrizes,
                expenditure = lottoPrice * lottoCount
            )
        )
    }
}
