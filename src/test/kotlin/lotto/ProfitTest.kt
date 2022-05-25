package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.round

class ProfitTest {
    @Test
    fun `소수점자리 표현하기`() {
        val x: Double = 500.0 / 1500.0
        assertThat(round(x * 100) / 100).isEqualTo(0.33)
    }

    @CsvSource(
        value = [
            "500.0, 1_500.0, 0.33",
            "5_000.0, 50_000.0, 0.1",
            "5_000.0, 150_000.0, 0.03",
            "5_000.0, 200_000.0, 0.02",
            "5_000.0, 5_000.0, 1"
        ]
    )
    @ParameterizedTest
    fun `로또당첨금액에 대한 수익률을 계산한다`(profit: Double, payment: Double, expect: Double) {
        assertThat(Profit(profit, payment).yields).isEqualTo(expect)
    }
}
