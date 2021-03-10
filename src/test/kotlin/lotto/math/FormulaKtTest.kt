package lotto.math

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class FormulaKtTest {

    @Test
    @DisplayName("원하는 자리의 반올림이 가능하다.")
    fun roundTo() {
        // given
        val value = 8.353535353
        // when
        val roundTo2 = value.roundTo(2)
        val roundTo3 = value.roundTo(3)
        // then
        assertThat(roundTo2).isEqualTo(8.35)
        assertThat(roundTo3).isEqualTo(8.354)
    }

    @Test
    @DisplayName("수익률 계산이 가능하다.")
    fun getProfitTest() {
        val profit = getProfit(14000, 5000)
        assertThat(profit.roundTo(2)).isEqualTo(0.36)
    }
}
