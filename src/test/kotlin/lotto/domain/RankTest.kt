package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun match_first() {
        val rank = Rank()

        rank.addRank(6)

        assertThat(rank.ranks[PrizeMoney.FIRST]).isEqualTo(1)
        assertThat(rank.ranks[PrizeMoney.SECOND]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.THIRD]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FOURTH]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FIFTH]).isEqualTo(0)
    }

    @Test
    fun match_second() {
        val rank = Rank()

        rank.addRank(5, true)

        assertThat(rank.ranks[PrizeMoney.FIRST]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.SECOND]).isEqualTo(1)
        assertThat(rank.ranks[PrizeMoney.THIRD]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FOURTH]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FIFTH]).isEqualTo(0)
    }

    @Test
    fun match_third() {
        val rank = Rank()

        rank.addRank(5, false)
        rank.addRank(5)

        assertThat(rank.ranks[PrizeMoney.FIRST]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.SECOND]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.THIRD]).isEqualTo(2)
        assertThat(rank.ranks[PrizeMoney.FOURTH]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FIFTH]).isEqualTo(0)
    }

    @Test
    fun match_fourth() {
        val rank = Rank()

        rank.addRank(4)

        assertThat(rank.ranks[PrizeMoney.FIRST]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.SECOND]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.THIRD]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FOURTH]).isEqualTo(1)
        assertThat(rank.ranks[PrizeMoney.FIFTH]).isEqualTo(0)
    }

    @Test
    fun match_fifth() {
        val rank = Rank()

        rank.addRank(3)

        assertThat(rank.ranks[PrizeMoney.FIRST]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.SECOND]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.THIRD]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FOURTH]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FIFTH]).isEqualTo(1)
    }

    @Test
    fun is_not_rank() {
        val rank = Rank()

        rank.addRank(0)

        assertThat(rank.ranks[PrizeMoney.FIFTH]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FOURTH]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.THIRD]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.SECOND]).isEqualTo(0)
        assertThat(rank.ranks[PrizeMoney.FIRST]).isEqualTo(0)
    }
}
