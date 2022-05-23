package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class ProfitTest : StringSpec({

    "구입 금액과 당첨 금액합이 일치하면 수익률은 1.0 이다" {
        val money = Money(50000)
        val results = listOf(
            LottoMatchResult(3, Money(5000), 2),
            LottoMatchResult(4, Money(10000), 4),
        )

        val profit = Profit(money, results)

        profit.value shouldBe 1.0
    }

    "구입 금액이 당첨 금액합보다 큰 경우 수익률은 1.0 보다 작다" {
        val money = Money(50000)
        val results = listOf(
            LottoMatchResult(3, Money(5000), 4),
            LottoMatchResult(4, Money(10000), 0),
        )

        val profit = Profit(money, results)

        profit.value shouldBe 0.4
    }

    "구입 금액이 당첨 금액합보다 적은경우 수익률은 1.0 보다 크다" {
        val money = Money(50000)
        val results = listOf(
            LottoMatchResult(5, Money(50000), 1),
            LottoMatchResult(6, Money(100000), 1),
        )

        val profit = Profit(money, results)

        profit.value shouldBe 3.0
    }
})
