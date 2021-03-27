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
    private val winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)
    private val sixCorrectLotto = lottoOf(1, 2, 3, 4, 5, 6)
    private val fiveCorrectLotto = lottoOf(1, 2, 3, 4, 5, 45)
    private val fourCorrectLotto = lottoOf(1, 2, 3, 4, 44, 45)
    private val threeCorrectLotto = lottoOf(1, 2, 3, 43, 44, 45)
    private val noCorrectLotto = lottoOf(40, 41, 42, 43, 44, 45)

    @Test
    fun `당첨통계는 당첨로또숫자열과 로또 리스트와 로또 하나의 가격으로 생성된다`() {
        assertDoesNotThrow {
            WinningStatistics(
                winningNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6),
                lottos = listOf(lottoOf(1, 2, 3, 4, 5, 6))
            )
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1,3,5,7,9",
        "7,0,8,1,9"
    )
    fun `당첨통계는 총 당첨금을 알려준다`(
        sixCorrectCount: Int,
        fiveCorrectCount: Int,
        fourCorrectCount: Int,
        threeCorrectCount: Int,
        noCorrectCount: Int
    ) {
        val statistics = WinningStatistics(
            winningNumbers = winningNumbers,
            lottos = List(sixCorrectCount) { sixCorrectLotto } +
                List(fiveCorrectCount) { fiveCorrectLotto } +
                List(fourCorrectCount) { fourCorrectLotto } +
                List(threeCorrectCount) { threeCorrectLotto } +
                List(noCorrectCount) { noCorrectLotto }
        )

        val expectedTotalPrizes = (WinningCategory.SIX_CORRECT.prize * sixCorrectCount) +
            (WinningCategory.FIVE_CORRECT.prize * fiveCorrectCount) +
            (WinningCategory.FOUR_CORRECT.prize * fourCorrectCount) +
            (WinningCategory.THREE_CORRECT.prize * threeCorrectCount)

        assertThat(statistics.totalWinningPrizes).isEqualTo(expectedTotalPrizes)
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
            winningNumbers = winningNumbers,
            lottos = List(lottoCount) { sixCorrectLotto }
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
