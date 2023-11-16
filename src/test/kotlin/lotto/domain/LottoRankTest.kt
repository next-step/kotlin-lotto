package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `6개가 일치하면 1등`() {
        assertThat(LottoRank.getRank(6, false)).isEqualTo(LottoRank.FIRST)
    }

    @Test
    fun `5개가 일치하고 보너스 번호가 일치하면 2등`() {
        assertThat(LottoRank.getRank(5, true)).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `5개가 일치하고 보너스 번호가 다르면 3등`() {
        assertThat(LottoRank.getRank(5, false)).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `4개가 일치하면 4등`() {
        assertThat(LottoRank.getRank(4, false)).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `3개가 일치하면 5등`() {
        assertThat(LottoRank.getRank(3, false)).isEqualTo(LottoRank.FIFTH)
    }

    @Test
    fun `일치하는 개수가 2개 이하면 MISS`() {
        assertThat(LottoRank.getRank(2, false)).isEqualTo(LottoRank.MISS)
    }
}
