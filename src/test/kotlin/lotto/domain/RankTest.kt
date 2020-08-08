package lotto.domain

import lotto.domain.Rank.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RankTest {

    @DisplayName("일치 조건에 따라 알맞은 등수를 반환한다")
    @Test
    fun `match rank`() {
        assertThat(of(6, false)).isEqualTo(Rank.FIRST)
        assertThat(of(5, true)).isEqualTo(Rank.SECOND)
        assertThat(of(5, false)).isEqualTo(Rank.THIRD)
        assertThat(of(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(of(3, false)).isEqualTo(Rank.FIFTH)
    }

    @DisplayName("일치 조건에 따라 알맞은 당첨금을 반환한다")
    @Test
    fun `get prize money`() {
        assertThat(of(6, false).prizeMoney).isEqualTo(2_000_000_000)
        assertThat(of(5, true).prizeMoney).isEqualTo(30_000_000)
        assertThat(of(5, false).prizeMoney).isEqualTo(1_500_000)
        assertThat(of(4, false).prizeMoney).isEqualTo(50_000)
        assertThat(of(3, false).prizeMoney).isEqualTo(5_000)
    }
}
