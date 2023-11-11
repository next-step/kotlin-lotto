package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `6개가 일치하면 1등`() {
        assertThat(LottoRank.getRank(6)).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `5개가 일치하면 2등`() {
        assertThat(LottoRank.getRank(5)).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `4개가 일치하면 3등`() {
        assertThat(LottoRank.getRank(4)).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `3개가 일치하면 4등`() {
        assertThat(LottoRank.getRank(3)).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `일치하는 개수가 2개 이하면 MISS`() {
        assertThat(LottoRank.getRank(2)).isEqualTo(LottoRank.MISS)
    }
}
