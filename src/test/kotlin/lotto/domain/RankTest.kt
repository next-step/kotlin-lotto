package lotto.domain

import lotto.domain.Rank.Companion.getRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RankTest {

    @DisplayName("매칭성공 개수에 맞는 알맞은 등수를 반환한다")
    @Test
    fun `match rank`() {
        assertThat(getRank(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(getRank(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(getRank(5, false)).isEqualTo(Rank.THIRD)
        assertThat(getRank(5, true)).isEqualTo(Rank.SECOND)
        assertThat(getRank(6, false)).isEqualTo(Rank.FIRST)
    }

    @DisplayName("매칭성공 개수에 맞는 알맞은 당첨금을 반환한다")
    @Test
    fun `get prize money`() {
        assertThat(getRank(3, false).prizeMoney).isEqualTo(5_000)
        assertThat(getRank(4, false).prizeMoney).isEqualTo(50_000)
        assertThat(getRank(5, false).prizeMoney).isEqualTo(1_500_000)
        assertThat(getRank(5, true).prizeMoney).isEqualTo(30_000_000)
        assertThat(getRank(6, false).prizeMoney).isEqualTo(2_000_000_000)
    }
}
