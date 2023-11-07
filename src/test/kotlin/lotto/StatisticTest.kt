package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class StatisticTest {

    @Test
    fun `3개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 3 to 1)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo(BigDecimal("0.5"))
    }

    @Test
    fun `4개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 4 to 2)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo(BigDecimal("10"))
    }

    @Test
    fun `5개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 5 to 3)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo(BigDecimal("450"))
    }
}
