package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RankTest {

    @Test
    fun `match count 가 6인 경우 1등`() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `match count 가 5이고 bonusBall 이 일치 할 때 경우 2등`() {
        assertThat(Rank.of(6, true)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `match count 가 5인 경우 3등`() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `match count 가 4인 경우 4등`() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `match count 가 3인 경우 5등`() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH)
    }

    @ParameterizedTest(name = "match count 가 {0}일 경우 miss")
    @ValueSource(ints = [0, 1, 2])
    fun `match count 가 3미만인 경우 miss`(matchCount: Int) {
        assertThat(Rank.of(matchCount, false)).isEqualTo(Rank.MISS)
    }
}
