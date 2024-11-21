package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RanksTest() {
    @Test
    fun `일치갯수를 파악할수 있다`() {
        val actual = Ranks.fromGroupBy(listOf(Rank.FIRST, Rank.FIRST, Rank.SECOND))

        assertAll(
            { assertThat(actual.count(Rank.FIRST)).isEqualTo(2) },
            { assertThat(actual.count(Rank.SECOND)).isEqualTo(1) },
        )
    }
}
