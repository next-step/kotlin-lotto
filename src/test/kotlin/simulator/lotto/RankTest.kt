package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class RankTest {
    @Test
    fun `등수별로 상금을 반환한다`() {
        assertThat(Rank.FIRST.winningMoney).isEqualTo(2_000_000_000)
        assertThat(Rank.SECOND.winningMoney).isEqualTo(30_000_000)
        assertThat(Rank.THIRD.winningMoney).isEqualTo(1_500_000)
        assertThat(Rank.FOURTH.winningMoney).isEqualTo(50_000)
        assertThat(Rank.FIFTH.winningMoney).isEqualTo(5_000)
        assertThat(Rank.MISS.winningMoney).isEqualTo(0)
    }

    @Test
    fun `맞는 로또 갯수에 따라 등수를 반환한다`() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS)
    }

    @Test
    fun `맞는 로또 갯수가 존재하지 않는다면 MISS를 반환한다`() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS)
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS)
    }
}