package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `rank() 6개 맞추면 1등`() {
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST_PRIZE)
        assertThat(Rank.of(6).prize).isEqualTo(2000000000)
    }

    @Test
    fun `rank() 5개 맞추면 2등`() {
        assertThat(Rank.of(5)).isEqualTo(Rank.SECOND_PRIZE)
        assertThat(Rank.of(5).prize).isEqualTo(1500000)
    }

    @Test
    fun `rank() 4개 맞추면 3등`() {
        assertThat(Rank.of(4)).isEqualTo(Rank.THIRD_PRIZE)
        assertThat(Rank.of(4).prize).isEqualTo(50000)
    }

    @Test
    fun `rank() 3개 맞추면 4등`() {
        assertThat(Rank.of(3)).isEqualTo(Rank.FOURTH_PRIZE)
        assertThat(Rank.of(3).prize).isEqualTo(5000)
    }

    @Test
    fun `rank() 2개 맞추면 등수 없음`() {
        assertThat(Rank.of(2)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(2).prize).isEqualTo(0)
    }

    @Test
    fun `rank() 1개 맞추면 등수 없음`() {
        assertThat(Rank.of(1)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(1).prize).isEqualTo(0)
    }

    @Test
    fun `rank() 0개 맞추면 등수 없음`() {
        assertThat(Rank.of(1)).isEqualTo(Rank.NONE)
        assertThat(Rank.of(1).prize).isEqualTo(0)
    }
}
