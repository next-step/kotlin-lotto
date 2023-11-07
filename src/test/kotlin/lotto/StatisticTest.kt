package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class StatisticTest {

    @Test
    fun `3개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 3 to 1)

        val actual = sut.profit

        assertThat(actual).isEqualByComparingTo(BigDecimal("0.5"))
    }
}
