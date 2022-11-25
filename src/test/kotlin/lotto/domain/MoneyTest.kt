package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoneyTest : StringSpec({

    "수익률을 반환한다" {
        val money = Money(1000)
        val winner = Winner((1..45).toList())
        val lotto = Lotto(1)
        val tickets = lotto.purchaseTicket()
        val matchingInfo = winner.checkNumberMatch(tickets)
        money.setRevenueRate(matchingInfo)
        money.getRevenueRate() shouldBe 2000000.0
    }
})
