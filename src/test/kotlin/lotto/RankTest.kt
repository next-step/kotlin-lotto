package lotto

import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun prizeBonus() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.FIVE_BONUS_MATCH)
    }
}
