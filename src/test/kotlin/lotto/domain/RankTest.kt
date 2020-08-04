package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun check_in_rank() {
        val rank = Rank()

        rank.joinRank(3)
        rank.joinRank(3)

        assertThat(rank.ranks[3]).isEqualTo(2)
    }

    @Test
    fun is_not_rank() {
        val rank = Rank()

        rank.joinRank(2)

        assertThat(rank.ranks[3]).isEqualTo(0)
    }
}
