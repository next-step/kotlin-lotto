package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

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
    fun `통계 조회를 하면 3개부터 6개까지 일치하는 개수를 알려준다`() {
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val sixCorrectLotto = Lotto(1, 2, 3, 4, 5, 6)
        val fiveCorrectLotto = Lotto(2, 3, 4, 5, 6, 7)
        val fourCorrectLotto = Lotto(3, 4, 5, 6, 7, 8)
        val threeCorrectLotto = Lotto(4, 5, 6, 7, 8, 9)
        val noCorrectLotto = Lotto(40, 41, 42, 43, 44, 45)

        var statistics = WinningStatistics(
            winningNumbers = winningNumbers,
            lottos = List(1) { sixCorrectLotto } +
                List(2) { fiveCorrectLotto } +
                List(3) { fourCorrectLotto } +
                List(4) { threeCorrectLotto } +
                List(5) { noCorrectLotto },
            lottoUnitPrice = Money(1000)
        )

        assertThat(statistics.countLottoBy(WinningCategory.SIX_CORRECT)).isEqualTo(1)
        assertThat(statistics.countLottoBy(WinningCategory.FIVE_CORRECT)).isEqualTo(2)
        assertThat(statistics.countLottoBy(WinningCategory.FOUR_CORRECT)).isEqualTo(3)
        assertThat(statistics.countLottoBy(WinningCategory.THREE_CORRECT)).isEqualTo(4)

        statistics = WinningStatistics(
            winningNumbers = winningNumbers,
            lottos = List(5) { sixCorrectLotto } +
                List(4) { fiveCorrectLotto } +
                List(3) { fourCorrectLotto } +
                List(2) { threeCorrectLotto } +
                List(1) { noCorrectLotto },
            lottoUnitPrice = Money(1000)
        )

        assertThat(statistics.countLottoBy(WinningCategory.SIX_CORRECT)).isEqualTo(5)
        assertThat(statistics.countLottoBy(WinningCategory.FIVE_CORRECT)).isEqualTo(4)
        assertThat(statistics.countLottoBy(WinningCategory.FOUR_CORRECT)).isEqualTo(3)
        assertThat(statistics.countLottoBy(WinningCategory.THREE_CORRECT)).isEqualTo(2)
    }
}
