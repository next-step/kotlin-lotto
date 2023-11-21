package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.RoundingMode

class LottoMachineTest {

    @Test
    fun `여러 개의 로또 통계 추출`() {
        val expectLottos = listOf(
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(1, 2, 3, 4, 5, 7),
            Lotto(1, 2, 3, 4, 5, 8),
            Lotto(1, 2, 3, 4, 7, 8),
            Lotto(1, 2, 3, 7, 8, 9),
            Lotto(1, 2, 3, 7, 8, 9),
            Lotto(7, 8, 9, 10, 11, 12),
            Lotto(7, 8, 9, 10, 11, 12),
        )
        val money = expectLottos.size * LOTTO_PRICE
        val sut = LottoMachine(money) { expectLottos }

        val actual = sut.issueStatistics(WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber(7)))

        val expectTotalProfit = 4031560000L.toBigDecimal()
        val expectProfitRate = expectTotalProfit.divide(money.toBigDecimal(), 2, RoundingMode.CEILING)
        assertThat(actual.profitRate).isEqualByComparingTo(expectProfitRate)
        assertThat(actual.countOf(Rank.FIRST)).isEqualTo(2)
        assertThat(actual.countOf(Rank.SECOND)).isEqualTo(1)
        assertThat(actual.countOf(Rank.THIRD)).isEqualTo(1)
        assertThat(actual.countOf(Rank.FOURTH)).isEqualTo(1)
        assertThat(actual.countOf(Rank.FIFTH)).isEqualTo(2)
        assertThat(actual.countOf(Rank.NOTHING)).isEqualTo(2)
    }

}
