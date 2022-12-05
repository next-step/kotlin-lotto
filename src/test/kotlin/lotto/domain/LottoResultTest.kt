package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : DescribeSpec({
    describe("로또 추첨 결과 테스트") {
        it("결제금액과 추첨 결과만 있으면 수익률을 계산할 수 있다.") {
            val purchasePrice = Money(14000)
            val matchesResult = mapOf(
                LottoReward.MATCH_THREE.rewardPrice to 1,
                LottoReward.MATCH_FOUR.rewardPrice to 0,
                LottoReward.MATCH_FIVE.rewardPrice to 0,
                LottoReward.MATCH_SIX.rewardPrice to 0
            )
            val lottoWinningAmount = LottoWinningAmount(matchesResult)

            val lottoResult = LottoResult(purchasePrice, lottoWinningAmount)

            lottoResult.calculateReturnRate() shouldBe 0.36
        }
    }
})
