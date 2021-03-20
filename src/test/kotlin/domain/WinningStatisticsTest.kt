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
        val fiveCorrectLotto = Lotto(2, 3, 4, 5, 6, 7)
        val fourCorrectLotto = Lotto(3, 4, 5, 6, 7, 8)
        val threeCorrectLotto = Lotto(4, 5, 6, 7, 8, 9)
        val noCorrectLotto = Lotto(40, 41, 42, 43, 44, 45)

        val statistics = WinningStatistics(
            winningNumbers = winningNumbers,
            lottos = List(sixCorrectCount) { sixCorrectLotto } +
                List(fiveCorrectCount) { fiveCorrectLotto } +
                List(fourCorrectCount) { fourCorrectLotto } +
                List(threeCorrectCount) { threeCorrectLotto } +
                List(noCorrectCount) { noCorrectLotto },
            lottoUnitPrice = Money(1000)
        )

        assertThat(statistics.countLottoBy(WinningCategory.SIX_CORRECT)).isEqualTo(sixCorrectCount)
        assertThat(statistics.countLottoBy(WinningCategory.FIVE_CORRECT)).isEqualTo(fiveCorrectCount)
        assertThat(statistics.countLottoBy(WinningCategory.FOUR_CORRECT)).isEqualTo(fourCorrectCount)
        assertThat(statistics.countLottoBy(WinningCategory.THREE_CORRECT)).isEqualTo(threeCorrectCount)
    }
}
