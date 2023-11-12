package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.RoundingMode

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["999, 0", "1001, 1", "13000, 13", "123441, 123"])
    fun `입력 금액 만큼 로또 생성`(money: Int, expectSize: Int) {
        val expectLottos = (0 until expectSize).map { _ -> Lotto(1, 2, 3, 4, 5, 6) }
        val sut = LottoMachine(lottoGenerator(expectLottos))
        sut.inputMoney(money)

        val actualLottos = sut.issuedLottos()

        assertThat(actualLottos).hasSize(expectSize)
    }

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
        val sut = LottoMachine(lottoGenerator(expectLottos))
        sut.inputMoney(money)

        val actual = sut.issueStatistics(WinningLotto(Lotto(1, 2, 3, 4, 5, 6), 7))

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

    private fun lottoGenerator(lottos: List<Lotto>): LottoGenerator {
        val expectedLotto = lottos.iterator()
        return LottoGenerator { expectedLotto.next() }
    }
}
