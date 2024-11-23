package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IncomeTest : StringSpec({
    val sut = LottoIncomeCalculator()

    "당첨 금액이 0이라면 수익률은 0이다" {
        val inputMoney = Money(1000)
        val winningMoney = Money(0)

        val actual = sut.calculate(inputMoney, winningMoney)

        actual shouldBe IncomeRate(0.0)
    }

    "수익률을 계산한다" {
        val inputMoney = Money(1000)
        val winningMoney = Money(2000)

        val actual = sut.calculate(inputMoney, winningMoney)

        actual shouldBe IncomeRate(2.0)
    }
})
