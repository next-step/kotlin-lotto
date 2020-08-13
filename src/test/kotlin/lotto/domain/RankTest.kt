package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `rank() 6개 맞추고 보너스 못맞춰도 1등`() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST_PRIZE)
        assertThat(Rank.of(6, false).prize).isEqualTo(2000000000)
    }

    @Test
    fun `rank() 6개 맞추고 보너스 맞춰도 1등`() {
        assertThat(Rank.of(6, true)).isEqualTo(Rank.FIRST_PRIZE)
        assertThat(Rank.of(6, true).prize).isEqualTo(2000000000)
    }

    @Test
    fun `rank() 5개 맞추고 보너스 맞추면 2등`() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND_PRIZE)
        assertThat(Rank.of(5, true).prize).isEqualTo(30000000)
    }

    @Test
    fun `rank() 5개 맞추고 보너스 못맞추면 3등`() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD_PRIZE)
        assertThat(Rank.of(5, false).prize).isEqualTo(1500000)
    }

    @Test
    fun `rank() 4개 맞추면 4등`() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH_PRIZE)
        assertThat(Rank.of(4, false).prize).isEqualTo(50000)
    }

    @Test
    fun `rank() 3개 맞추면 5등`() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH_PRIZE)
        assertThat(Rank.of(3, false).prize).isEqualTo(5000)
    }

    @Test
    fun `rank() 2개 맞추면 등수 없음`() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(2, false).prize).isEqualTo(0)
    }

    @Test
    fun `rank() 1개 맞추면 등수 없음`() {
        assertThat(Rank.of(1, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(1, false).prize).isEqualTo(0)
    }

    @Test
    fun `rank() 0개 맞추면 등수 없음`() {
        assertThat(Rank.of(1, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(1, false).prize).isEqualTo(0)
    }
}
