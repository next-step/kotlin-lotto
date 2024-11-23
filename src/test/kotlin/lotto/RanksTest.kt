package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RanksTest {
    @Test
    fun `일치갯수를 파악할수 있다`() {
        val actual = Ranks.fromGroupBy(listOf(Rank.FIRST, Rank.FIRST, Rank.SECOND))

        assertAll(
            { assertThat(actual.count(Rank.FIRST)).isEqualTo(2) },
            { assertThat(actual.count(Rank.SECOND)).isEqualTo(1) },
        )
    }

    @Test
    fun `rate 를 계산할수 있다`() {
        val actual = Ranks.fromGroupBy(listOf(Rank.FOURTH))

        assertThat(actual.rate(Amount(14000))).isEqualTo(0.35.toBigDecimal())
    }

    @Test
    fun `count 각 랭크 일치 갯수 알수 있다`() {
        val actual = Ranks.fromGroupBy(listOf(Rank.FIRST, Rank.MISS, Rank.MISS))

        assertAll(
            { assertThat(actual.count(Rank.FIRST)).isEqualTo(1) },
            { assertThat(actual.count(Rank.MISS)).isEqualTo(2) },
        )
    }
}
