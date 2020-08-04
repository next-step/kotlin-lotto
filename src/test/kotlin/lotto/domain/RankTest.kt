package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun check_in_rank() {
        val rank = Rank()

        rank.joinRank("5등")
        rank.joinRank("5등")

        assertThat(rank.ranks["5등"]).isEqualTo(2)
    }

    @Test
    fun is_not_rank() {
        val rank = Rank()

        rank.joinRank("No Rank")

        assertThat(rank.ranks["5등"]).isEqualTo(0)
    }
}
