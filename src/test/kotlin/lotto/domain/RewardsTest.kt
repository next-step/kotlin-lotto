package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlin.math.floor

internal class RewardsTest : StringSpec({
    val rewards = Rewards(mutableListOf(Rank.FOURTH))

    "구매 금액과 당첨금으로 수익률을 반환한다." {
        val purchaseAmount = 14000.00
        val rateOfReturn = rewards.calculateRateOfReturn(purchaseAmount)
        floor(rateOfReturn * 100) / 100 shouldBe 0.35
    }
})
