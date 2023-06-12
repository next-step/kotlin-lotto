package lotto.domain.strategy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Money
import lotto.domain.ProfitRate

class LottoProfitCalculatorTest : FunSpec({
    val profitCalculator = LottoProfitCalculator

    test("구입금액과 당첨금을 가지고 수익율을 계산해 반환한다.") {
        val actual = profitCalculator.calculate(inputMoney = Money(14000), winningAmount = Money(5000))

        actual shouldBe ProfitRate(0.35)
    }

    test("당첨금이 존재하지 않으면 수익율은 없다.") {
        val actual = profitCalculator.calculate(inputMoney = Money(5000), winningAmount = Money(0))

        actual shouldBe ProfitRate(0.0)
    }
})
