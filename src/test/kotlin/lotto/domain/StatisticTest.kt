package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StatisticTest {

    @Test
    fun `5등 로또 수익률을 계산한다`() {
        val sut = Statistics(10000, Rank.FIFTH to 1)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("0.5".toBigDecimal())
    }

    @Test
    fun `4등 로또 수익률을 계산한다`() {
        val sut = Statistics(10000, Rank.FOURTH to 2)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("10".toBigDecimal())
    }

    @Test
    fun `3등 로또 수익률을 계산한다`() {
        val sut = Statistics(10000, Rank.THIRD to 3)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("450".toBigDecimal())
    }

    @Test
    fun `2등 로또 수익률을 계산한다`() {
        val sut = Statistics(10000, Rank.SECOND to 2)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("6000".toBigDecimal())
    }

    @Test
    fun `1등 로또 수익률을 계산한다`() {
        val sut = Statistics(10000, Rank.FIRST to 1)

        val actual = sut.profitRate

        assertThat(actual).isEqualByComparingTo("200000".toBigDecimal())
    }

    @Test
    fun `통계가 가지고 있는 등수 갯수를 조회한다`() {
        val sut = Statistics(10000, Rank.FIRST to 1, Rank.SECOND to 2, Rank.THIRD to 12, Rank.FIFTH to 23)

        assertThat(sut.countOf(Rank.FIRST)).isEqualTo(1)
        assertThat(sut.countOf(Rank.SECOND)).isEqualTo(2)
        assertThat(sut.countOf(Rank.THIRD)).isEqualTo(12)
        assertThat(sut.countOf(Rank.FOURTH)).isEqualTo(0)
        assertThat(sut.countOf(Rank.FIFTH)).isEqualTo(23)
        assertThat(sut.countOf(Rank.NOTHING)).isEqualTo(0)
    }
}
