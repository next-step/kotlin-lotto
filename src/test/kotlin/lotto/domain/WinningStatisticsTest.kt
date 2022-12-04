package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class WinningStatisticsTest : BehaviorSpec({
    given("14000원으로 자동 로또를 구매했을 때") {
        val purchasedAmount = PurchaseAmount(14000)

        `when`("13장 중 1장이 5등에 당첨됐다면") {
            val matchResult: Map<Rank, Int> = mapOf(
                Rank.MISS to 13,
                Rank.FIFTH to 1
            )
            val statistics = WinningStatistics(matchResult)

            then("수익률은 0.35 이다. (소수점 두자리까지 표시)") {
                statistics.calculateRateOfReturn(purchasedAmount).toString() shouldBe 0.35.toString()
            }
        }
    }
})
