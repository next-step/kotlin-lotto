package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatisticTest {

    @Test
    fun `3개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 3 to 1)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("0.5".toBigDecimal())
    }

    @Test
    fun `4개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 4 to 2)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("10".toBigDecimal())
    }

    @Test
    fun `5개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 5 to 3)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("450".toBigDecimal())
    }

    @Test
    fun `6개 일치 시 수익률을 계산한다`() {
        val sut = Statistics(10000, 6 to 1)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("200000".toBigDecimal())
    }
}
