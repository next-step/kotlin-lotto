package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoneyTest : StringSpec({

    "수익률을 반환한다" {
        val money = Money(1000)
        MatchInfo(mutableMapOf(Reward.FIFTH to 1)).getRevenueRate(money) shouldBe 5.0
    }
})
