package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `6개 맞추면 1등이다`() {
        val rank = Rank.from(matchCount = 6, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `5개와 보너스 볼을 맞추면 2등이다`() {
        val rank = Rank.from(matchCount = 5, matchBonus = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `5개 맞추고 보너스 볼을 못 맞추면 3등이다`() {
        val rank = Rank.from(matchCount = 5, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `4개 맞추면 4등이다`() {
        val rank = Rank.from(matchCount = 4, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `3개 맞추면 5등이다`() {
        val rank = Rank.from(matchCount = 3, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `2개 이하 맞추면 미당첨이다`() {
        val rank2 = Rank.from(matchCount = 2, matchBonus = false)
        val rank1 = Rank.from(matchCount = 1, matchBonus = false)
        val rank0 = Rank.from(matchCount = 0, matchBonus = false)

        assertThat(rank2).isEqualTo(Rank.NONE)
        assertThat(rank1).isEqualTo(Rank.NONE)
        assertThat(rank0).isEqualTo(Rank.NONE)
    }
}
