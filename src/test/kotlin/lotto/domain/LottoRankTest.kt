package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoRankTest {
    @DisplayName("1등 당첨")
    @Test
    fun `1등 당첨`() {
        // given
        val lottoRank = LottoRank.valueOf(6)

        // when, then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST)
    }

    @DisplayName("3등 당첨")
    @Test
    fun `3등 당첨`() {
        // given
        val lottoRank = LottoRank.valueOf(5)

        // when, then
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD)
    }

    @DisplayName("낙첨")
    @Test
    fun `낙첨`() {
        // given
        val lottoRank = LottoRank.valueOf(2)

        // when, then
        assertThat(lottoRank).isEqualTo(LottoRank.MISS)
    }
}
