package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.model.LottoMatchResult
import lotto.model.LottoMatchResults
import lotto.model.LottoPrize
import lotto.util.MathCalculator
import org.junit.jupiter.api.Test

class LottoMatchResultTest {
    @Test
    fun `수익률 계산을 올바르게 한다`() {
        val matchResults =
            listOf(
                // 2 * 5,000 = 10,000
                LottoMatchResult(LottoPrize.THREE, 2),
                // 1 * 150,000 = 150,000
                LottoMatchResult(LottoPrize.FIVE, 1),
            )
        val lottoMatchResults = LottoMatchResults.from(matchResults)

        val purchaseAmount = 100_000
        // 160000 / 100000 = 1.60
        val expectedReturnRate = MathCalculator.calculateRatio(160_000.0, 100_000.0, 2)

        lottoMatchResults.calculateReturnRate(purchaseAmount) shouldBe expectedReturnRate
    }

    @Test
    fun `메서드에서 구매 금액이 0일 경우 예외를 던진다`() {
        val matchResults =
            listOf(
                LottoMatchResult(LottoPrize.THREE, 2),
            )
        val lottoMatchResults = LottoMatchResults.from(matchResults)

        shouldThrow<IllegalArgumentException> {
            lottoMatchResults.calculateReturnRate(0)
        }.message shouldBe "분모는 0이 될 수 없습니다."
    }

    @Test
    fun `LottoMatchResults에 해당하는 LottoPrize가 없으면 findMatchCount는 0을 반환해야 한다`() {
        val matchResults =
            listOf(
                LottoMatchResult(LottoPrize.THREE, 2),
            )
        val lottoMatchResults = LottoMatchResults.from(matchResults)

        lottoMatchResults.findMatchCount(LottoPrize.FIVE) shouldBe 0
    }
}
