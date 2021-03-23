package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoRankTest {

    @Test
    fun `3등`() {
        assertThat(LottoRank.matchRank(5, false)).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `2등`() {
        assertThat(LottoRank.matchRank(5, true)).isEqualTo(LottoRank.SECOND)
    }
}
