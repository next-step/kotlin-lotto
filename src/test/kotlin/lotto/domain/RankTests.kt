package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RankTests {
    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `3개 맞으면 5천원 짜리 당첨이야`(matchBonus: Boolean) {
        assertThat(Rank.getRankByCount(3, matchBonus))
            .isEqualTo(Rank.FIFTH)
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `4개 맞으면 5만원 짜리 당첨이야`(matchBonus: Boolean) {
        assertThat(Rank.getRankByCount(4, matchBonus))
            .isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `5개 맞고 보너스 안맞으면 150만원 짜리 당첨이야`() {
        assertThat(Rank.getRankByCount(5, false))
            .isEqualTo(Rank.THIRD)
    }

    @Test
    fun `5개 맞고 보너스 맞으면 3000만원 짜리 당첨이야`() {
        assertThat(Rank.getRankByCount(5, true))
            .isEqualTo(Rank.SECOND)
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `6개 맞으면 집사야지`(matchBonus: Boolean) {
        assertThat(Rank.getRankByCount(6, matchBonus))
            .isEqualTo(Rank.FIRST)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `그 외에는 돈이 아깝두아`(count: Int) {
        assertThat(Rank.getRankByCount(count, false))
            .isEqualTo(Rank.FAIL)
    }
}
