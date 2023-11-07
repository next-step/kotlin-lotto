package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.RoundingMode

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["1000, 1", "13000, 13", "123441, 123"])
    fun `입력 금액 만큼 로또 생성`(money: Int, expectSize: Int) {
        val expectLottos = (0 until expectSize).map { _ -> Lotto(1, 2, 3, 4, 5, 6) }
        val sut = LottoMachine(lottoGenerator(expectLottos), money)

        val actualLottos = sut.issuedLottos

        assertThat(actualLottos).isEqualTo(expectLottos)
    }

    @Test
    fun `여러 개의 로또 통계 추출`() {
        val expectLottos = listOf(
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(1, 2, 3, 4, 5, 6),
            Lotto(1, 2, 3, 4, 5, 7),
            Lotto(1, 2, 3, 4, 7, 8),
            Lotto(1, 2, 3, 7, 8, 9),
            Lotto(1, 2, 3, 7, 8, 9),
        )
        val money = 6000
        val sut = LottoMachine(lottoGenerator(expectLottos), money)

        val actual = sut.issueStatistics(Lotto(1, 2, 3, 4, 5, 6))

        val expectTotalProfit = 4001560000L.toBigDecimal()
        val expectProfitRate = expectTotalProfit.divide(money.toBigDecimal(), 2, RoundingMode.CEILING)
        assertThat(actual.profitRate).isEqualByComparingTo(expectProfitRate)
    }

    private fun lottoGenerator(lottos: List<Lotto>): LottoGenerator {
        val expectedLotto = lottos.iterator()
        return LottoGenerator { expectedLotto.next() }
    }
}
