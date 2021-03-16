package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RankTests {
    @Test
    fun `3개 맞으면 5천원 짜리 당첨이야`() {
        assertThat(Rank.getRankByCount(3))
            .isEqualTo(Rank.FORTH)
    }
    @Test
    fun `4개 맞으면 5만원 짜리 당첨이야`() {
        assertThat(Rank.getRankByCount(4))
            .isEqualTo(Rank.THIRD)
    }
    @Test
    fun `5개 맞으면 150만원 짜리 당첨이야`() {
        assertThat(Rank.getRankByCount(5))
            .isEqualTo(Rank.SECOND)
    }
    @Test
    fun `6개 맞으면 집사야지`() {
        assertThat(Rank.getRankByCount(6))
            .isEqualTo(Rank.FIRST)
    }
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `그 외에는 돈이 아깝두아`(count: Int) {
        assertThat(Rank.getRankByCount(count))
            .isNull()
    }
}
