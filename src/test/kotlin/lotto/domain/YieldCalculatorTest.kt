package lotto.domain

import lotto.model.LottoResult
import lotto.model.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Created by Jaesungchi on 2022.05.26..
 */
class YieldCalculatorTest {
    @Test
    internal fun `1000원으로 4등 당첨시 수익률이 5 이다`() {
        val money = 1000
        val lists = listOf(LottoResult(Prize.FOURTH_PLACE, 1))
        assertThat(YieldCalculator.calculateYield(money, lists)).isEqualTo(5.0)
    }
}
