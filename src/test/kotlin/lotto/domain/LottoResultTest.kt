package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LottoResultTest {

    @Test
    fun `LottoRank 리스트를 전달해서 생성에 성공한다`() {
        // given
        val lottoRanks = listOf(LottoRank.MATCH_THREE, LottoRank.MATCH_FIVE)

        // expect
        assertDoesNotThrow { LottoResult(lottoRanks) }
    }

    @Test
    fun `getRankCount를 구하는데 성공한다`() {
        // given
        val lottoRanks = listOf(LottoRank.MATCH_THREE, LottoRank.MATCH_FIVE)

        // when
        val rankCount = LottoResult(lottoRanks).getRankCount(LottoRank.MATCH_FIVE)

        // then
        assertThat(rankCount).isEqualTo(1)
    }
}
