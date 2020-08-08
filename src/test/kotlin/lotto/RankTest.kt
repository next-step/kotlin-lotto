package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    internal fun rank() {
        assertThat(Rank.rank(6, true)).isEqualTo(Rank.FIRST)
        assertThat(Rank.rank(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.rank(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.rank(4, false)).isEqualTo(Rank.FORTH)
        assertThat(Rank.rank(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.rank(2, false)).isEqualTo(Rank.MISS)
    }

    @Test
    internal fun prizeByCount() {
        val prize = Rank.FIFTH.prizeByCount(3)
        assertThat(prize).isEqualTo(15_000)
    }
}
