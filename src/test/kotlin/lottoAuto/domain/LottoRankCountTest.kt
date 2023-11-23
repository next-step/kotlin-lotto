package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankCountTest {

    @Test
    fun `calcProfit 함수 테스트 - 손해 확인`() {
        // given
        val purchaseAmount = 1000
        val lottoRankCounter = LottoRankCounter(
            mapOf(
                LottoRank.MISS to 6
            )
        )
        val expected = LottoProfit(
            rateOfReturn = 0 / purchaseAmount.toDouble(),
            resultMsg = "손해"
        )

        // when
        val profit = lottoRankCounter.calcProfit(purchaseAmount)

        // then
        assertEquals(expected, profit)
    }

    @Test
    fun `calcProfit 함수 테스트 - 이익 확인`() {
        // given
        val purchaseAmount = 1000
        val lottoRankCounter = LottoRankCounter(
            mapOf(
                LottoRank.FIRST to 1,
                LottoRank.FOURTH to 4,
                LottoRank.MISS to 6
            )
        )
        val expected = LottoProfit(
            rateOfReturn = 2_000_020_000 / 1000.0,
            resultMsg = "이익"
        )

        // when
        val profit = lottoRankCounter.calcProfit(purchaseAmount)

        // then
        assertEquals(expected, profit)
    }

    @Test
    fun `calcProfit 함수 테스트 - 본전 확인 `() {
        // given
        val purchaseAmount = 2_000_000_000
        val lottoRankCounter = LottoRankCounter(
            mapOf(
                LottoRank.FIRST to 1,
                LottoRank.MISS to 3
            )
        )
        val expected = LottoProfit(
            rateOfReturn = 2_000_000_000 / purchaseAmount.toDouble(),
            resultMsg = "본전"
        )

        // when
        val profit = lottoRankCounter.calcProfit(purchaseAmount)

        // then
        assertEquals(expected, profit)
    }
}
