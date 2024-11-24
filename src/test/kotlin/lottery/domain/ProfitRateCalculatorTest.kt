package lottery.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import lottery.domain.ProfitRateCalculator.calculate
import lottery.domain.RankReward.RANK_4

class ProfitRateCalculatorTest : StringSpec({
    "구입 금액과 결과를 계산하여 수익률을 반환한다" {
        val purchaseAmount = Money(200_000)
        val drawResult = DrawResult(mapOf(RANK_4 to LotteryCount(1)))

        calculate(purchaseAmount, drawResult) shouldBeExactly 0.025
    }
})
