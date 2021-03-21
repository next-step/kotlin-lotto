package domain

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
                winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6),
                lottos = listOf(Lotto(1, 2, 3, 4, 5, 6)),
                lottoUnitPrice = Money(1000)
            )
        }
    }

    @Test
    fun `당첨통계는 총 당첨금을 알려준다`() {
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val sixCorrectLotto = Lotto(1, 2, 3, 4, 5, 6)
        val fiveCorrectLotto = Lotto(1, 2, 3, 4, 5, 45)
        val fourCorrectLotto = Lotto(1, 2, 3, 4, 44, 45)
        val threeCorrectLotto = Lotto(1, 2, 3, 43, 44, 45)
        val noCorrectLotto = Lotto(40, 41, 42, 43, 44, 45)

        var statistics = WinningStatistics(
            winningNumbers = winningNumbers,
            lottos = sixCorrectLotto.nTimes(1) +
                fiveCorrectLotto.nTimes(3) +
                fourCorrectLotto.nTimes(5) +
                threeCorrectLotto.nTimes(7) +
                noCorrectLotto.nTimes(9),
            lottoUnitPrice = Money(1000)
        )

        var expectedTotalPrizes = (WinningCategory.SIX_CORRECT.prize * 1) +
            (WinningCategory.FIVE_CORRECT.prize * 3) +
            (WinningCategory.FOUR_CORRECT.prize * 5) +
            (WinningCategory.THREE_CORRECT.prize * 7)

        assertThat(statistics.totalWinningPrizes).isEqualTo(expectedTotalPrizes)

        statistics = WinningStatistics(
            winningNumbers = winningNumbers,
            lottos = sixCorrectLotto.nTimes(7) +
                fiveCorrectLotto.nTimes(0) +
                fourCorrectLotto.nTimes(8) +
                threeCorrectLotto.nTimes(1) +
                noCorrectLotto.nTimes(9),
            lottoUnitPrice = Money(1000)
        )

        expectedTotalPrizes = (WinningCategory.SIX_CORRECT.prize * 7) +
            (WinningCategory.FIVE_CORRECT.prize * 0) +
            (WinningCategory.FOUR_CORRECT.prize * 8) +
            (WinningCategory.THREE_CORRECT.prize * 1)

        assertThat(statistics.totalWinningPrizes).isEqualTo(expectedTotalPrizes)
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
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val sixCorrectLotto = Lotto(1, 2, 3, 4, 5, 6)
        val fiveCorrectLotto = Lotto(1, 2, 3, 4, 5, 45)
        val fourCorrectLotto = Lotto(1, 2, 3, 4, 44, 45)
        val threeCorrectLotto = Lotto(1, 2, 3, 43, 44, 45)
        val noCorrectLotto = Lotto(40, 41, 42, 43, 44, 45)

        val statistics = WinningStatistics(
            winningNumbers = winningNumbers,
            lottos = sixCorrectLotto.nTimes(sixCorrectCount) +
                fiveCorrectLotto.nTimes(fiveCorrectCount) +
                fourCorrectLotto.nTimes(fourCorrectCount) +
                threeCorrectLotto.nTimes(threeCorrectCount) +
                noCorrectLotto.nTimes(noCorrectCount),
            lottoUnitPrice = Money(1000)
        )

        assertThat(statistics.countLottoBy(WinningCategory.SIX_CORRECT)).isEqualTo(sixCorrectCount)
        assertThat(statistics.countLottoBy(WinningCategory.FIVE_CORRECT)).isEqualTo(fiveCorrectCount)
        assertThat(statistics.countLottoBy(WinningCategory.FOUR_CORRECT)).isEqualTo(fourCorrectCount)
        assertThat(statistics.countLottoBy(WinningCategory.THREE_CORRECT)).isEqualTo(threeCorrectCount)
    }

    private fun Lotto.nTimes(number: Int): List<Lotto> = List(number) { this }
}
