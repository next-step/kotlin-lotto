package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LottoResultTest {

    @Test
    fun `LottoRank 리스트를 전달해서 생성에 성공한다`() {
        // given
        val lottoRanks = listOf(LottoRank.FIRST, LottoRank.THIRD)

        // expect
        assertDoesNotThrow { LottoResult(lottoRanks, 2) }
    }

    @Test
    fun `getRankCount를 구하는데 성공한다`() {
        // given
        val lottoRanks = listOf(LottoRank.FIRST, LottoRank.THIRD)

        // when
        val rankCount = LottoResult(lottoRanks, 2).getRankCount(LottoRank.THIRD)

        // then
        assertThat(rankCount).isEqualTo(1)
    }

    @Test
    fun `getProfitRate을 구하는데성공한다`() {
        // given
        val lottoRanks = listOf(LottoRank.FIRST)

        // when
        val profitRate = LottoResult(lottoRanks, 1).getProfitRate()

        // then
        assertThat(profitRate).isEqualTo((LottoRank.FIRST.price / (1 * Lotto.LOTTO_PRICE)).toDouble())
    }
}
