package domain.statistics

import domain.lotto.Lotto
import domain.lotto.LottoNumbers
import domain.money.Money
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningStatisticsTest {
    private val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
    private val sixCorrectLotto = Lotto(1, 2, 3, 4, 5, 6)
    private val fiveCorrectLotto = Lotto(1, 2, 3, 4, 5, 45)
    private val fourCorrectLotto = Lotto(1, 2, 3, 4, 44, 45)
    private val threeCorrectLotto = Lotto(1, 2, 3, 43, 44, 45)
    private val noCorrectLotto = Lotto(40, 41, 42, 43, 44, 45)

    @Test
    fun `당첨통계는 당첨로또숫자열과 로또 리스트와 로또 하나의 가격으로 생성된다`() {
        assertDoesNotThrow {
            WinningStatistics(
                winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6),
                lottos = listOf(Lotto(1, 2, 3, 4, 5, 6))
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
        val statistics = makeStatisticsWithWinningCount(
            sixCorrectCount,
            fiveCorrectCount,
            fourCorrectCount,
            threeCorrectCount,
            noCorrectCount
        )

        val expectedTotalPrizes = (WinningCategory.SIX_CORRECT.prize * sixCorrectCount) +
            (WinningCategory.FIVE_CORRECT.prize * fiveCorrectCount) +
            (WinningCategory.FOUR_CORRECT.prize * fourCorrectCount) +
            (WinningCategory.THREE_CORRECT.prize * threeCorrectCount)

        Assertions.assertThat(statistics.totalWinningPrizes).isEqualTo(expectedTotalPrizes)
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5",
        "5,4,3,2,1"
    )
    fun `통계 조회를 하면 3개부터 6개까지 일치하는 개수를 알려준다`(
        sixCorrectCount: Int,
        fiveCorrectCount: Int,
        fourCorrectCount: Int,
        threeCorrectCount: Int,
        noCorrectCount: Int
    ) {
        val statistics = makeStatisticsWithWinningCount(
            sixCorrectCount,
            fiveCorrectCount,
            fourCorrectCount,
            threeCorrectCount,
            noCorrectCount
        )

        assertAll(
            { Assertions.assertThat(statistics.countLottoBy(WinningCategory.SIX_CORRECT)).isEqualTo(sixCorrectCount) },
            {
                Assertions.assertThat(statistics.countLottoBy(WinningCategory.FIVE_CORRECT)).isEqualTo(fiveCorrectCount)
            },
            {
                Assertions.assertThat(statistics.countLottoBy(WinningCategory.FOUR_CORRECT)).isEqualTo(fourCorrectCount)
            },
            {
                Assertions.assertThat(statistics.countLottoBy(WinningCategory.THREE_CORRECT))
                    .isEqualTo(threeCorrectCount)
            }
        )
    }

    @ParameterizedTest
    @CsvSource(
        "1000,0,1,2,3,4",
        "400,3,2,7,100,2000"
    )
    fun `당첨통계는 수익률을 알려준다`(
        lottoPriceValue: Long,
        sixCorrectCount: Int,
        fiveCorrectCount: Int,
        fourCorrectCount: Int,
        threeCorrectCount: Int,
        noCorrectCount: Int
    ) {
        val lottoPrice = Money(lottoPriceValue)
        val statistics = makeStatisticsWithWinningCount(
            sixCorrectCount,
            fiveCorrectCount,
            fourCorrectCount,
            threeCorrectCount,
            noCorrectCount
        )

        val totalWinningPrizes = statistics.totalWinningPrizes
        val lottoCount = sixCorrectCount + fiveCorrectCount + fourCorrectCount + threeCorrectCount + noCorrectCount

        assertThat(statistics.calculateRatioOfIncomeToExpenditure(lottoPrice))
            .isEqualTo(
                totalWinningPrizes.value.toDouble() / (lottoPrice.value * lottoCount).toDouble()
            )
    }

    private fun makeStatisticsWithWinningCount(
        sixCorrectCount: Int,
        fiveCorrectCount: Int,
        fourCorrectCount: Int,
        threeCorrectCount: Int,
        noCorrectCount: Int
    ) = WinningStatistics(
        winningNumbers = winningNumbers,
        lottos = sixCorrectLotto.nTimes(sixCorrectCount) +
            fiveCorrectLotto.nTimes(fiveCorrectCount) +
            fourCorrectLotto.nTimes(fourCorrectCount) +
            threeCorrectLotto.nTimes(threeCorrectCount) +
            noCorrectLotto.nTimes(noCorrectCount)
    )

    private fun Lotto.nTimes(number: Int): List<Lotto> = List(number) { this }
}
