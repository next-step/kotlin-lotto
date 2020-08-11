package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    @DisplayName("당첨수와 당첨금액으로 획득금액이 반환된다")
    fun `sumPrizeMoeny`() {
        val count = 10
        assertThat(Rank.FIFTH.sumPrizeMoney(count)).isEqualTo(count * Rank.FIFTH.prizeMoney)
    }

    @Test
    @DisplayName("당첨수와 보너스볼 매치가 참이면 2 등을 반환한다")
    fun `valueOfSecond`() {
        val countsOfMatch = 5
        val matchBonus = true

        assertThat(Rank.valueOf(countsOfMatch, matchBonus)).isEqualTo(Rank.SECOND)
    }

    @Test
    @DisplayName("당첨수와 보너스볼 매치가 참이면 3 등을 반환한다")
    fun `valueOfThird`() {
        val countsOfMatch = 5
        val matchBonus = false

        assertThat(Rank.valueOf(countsOfMatch, matchBonus)).isEqualTo(Rank.THIRD)
    }
}
