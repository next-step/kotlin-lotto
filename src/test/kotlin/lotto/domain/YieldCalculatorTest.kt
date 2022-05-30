package lotto.domain

import lotto.model.LottoResult
import lotto.model.LottoResults
import lotto.model.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * Created by Jaesungchi on 2022.05.26..
 */
class YieldCalculatorTest {
    @ParameterizedTest
    @CsvSource("1000, 5.0", "2000, 2.5", "4000, 1.25")
    internal fun `수익률 계산이 정확하게 동작한다`(money: Int, resultYield: Double) {
        val lists = LottoResults(listOf(LottoResult(Prize.FIFTH, 1)))
        assertThat(YieldCalculator.calculateYield(money, lists)).isEqualTo(resultYield)
    }
}
