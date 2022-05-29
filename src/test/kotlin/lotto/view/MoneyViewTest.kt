package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class MoneyViewTest : StringSpec({

    "금액 입력 안내 문구를 출력한다" {
        val io = StubIO(listOf("123"))
        val moneyView = MoneyView(io)

        moneyView.readMoney()

        io.printed shouldBe listOf("구입금액을 입력해 주세요.")
    }

    "금액을 입력받을 수 있다" {
        val io = StubIO(listOf("14000"))
        val moneyView = MoneyView(io)

        val money = moneyView.readMoney()

        money.amount shouldBe 14000
    }

    "유효한 금액을 입력하지 않으면 다시 입력을 요구한다" {
        val io = StubIO(listOf("invalid", "2000"))
        val moneyView = MoneyView(io)

        moneyView.readMoney()

        io.printed shouldBe listOf("구입금액을 입력해 주세요.", "숫자만 입력해 주세요.")
    }
})
