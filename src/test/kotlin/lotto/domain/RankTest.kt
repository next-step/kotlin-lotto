package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun match_test() {
        val rank = Rank()

        rank.addRank(PrizeMoney.FIRST)
        rank.addRank(PrizeMoney.SECOND)
        rank.addRank(PrizeMoney.THIRD)
        rank.addRank(PrizeMoney.FOURTH)
        rank.addRank(PrizeMoney.FIFTH)
        rank.addRank(PrizeMoney.MISS)

        assertThat(rank.ranks[PrizeMoney.FIRST]).isEqualTo(1)
        assertThat(rank.ranks[PrizeMoney.SECOND]).isEqualTo(1)
        assertThat(rank.ranks[PrizeMoney.THIRD]).isEqualTo(1)
        assertThat(rank.ranks[PrizeMoney.FOURTH]).isEqualTo(1)
        assertThat(rank.ranks[PrizeMoney.FIFTH]).isEqualTo(1)
    }
}
