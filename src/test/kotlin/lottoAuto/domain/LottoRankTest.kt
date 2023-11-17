package lottoAuto.domain

import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `BONUS LottoRank 생성 테스트`() {
        // given
        val matchCount = 5
        val withBonus = true

        // when
        val lottoRank = LottoRank.from(matchCount, withBonus)

        // then
        assert(lottoRank == LottoRank.BONUS)
    }

    @Test
    fun `SECOND LottoRank 생성 테스트`() {
        // given
        val matchCount = 5
        val withBonus = false

        // when
        val lottoRank = LottoRank.from(matchCount, withBonus)

        // then
        assert(lottoRank == LottoRank.SECOND)
    }

    @Test
    fun `MISS LottoRank 생성 테스트`() {
        // given
        val matchCount = 1
        val withBonus = true

        // when
        val lottoRank = LottoRank.from(matchCount, withBonus)

        // then
        assert(lottoRank == LottoRank.MISS)
    }
}
