package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    @DisplayName("Check to change Prize")
    fun prize() {
        Assertions.assertThat(Rank.findMatchCount(5)).isEqualTo(Rank.FIVE_MATCH)
    }
}
