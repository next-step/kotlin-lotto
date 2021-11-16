package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `2등 찾기 테스트`() {
        assertThat(Rank.valueOf(MatchingCount(5, true))).isEqualTo(Rank.SECOND)
    }
}
