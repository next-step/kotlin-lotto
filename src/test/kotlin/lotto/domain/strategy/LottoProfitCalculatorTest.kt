package lotto.domain.strategy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Money

class LottoProfitCalculatorTest : FunSpec({
    val profitCalculator = LottoProfitCalculator

    test("구입금액과 당첨금을 가지고 수익율을 계산해 반환한다.") {
        val actual = profitCalculator.calculate(inputMoney = Money(5000), winningAmount = Money(14000))

        actual shouldBe 0.35
    }

    test("당첨금이 존재하지 않으면 수익율은 없다.") {
        val actual = profitCalculator.calculate(inputMoney = Money(5000), winningAmount = Money(0))

        actual shouldBe 0.0
    }
})
