package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryMachineTest : StringSpec({
    "개당 로또를 10,000원에 사면 10개의 로또가 나온다" {
        val result = LotteryMachine.issueLotteryTicket(Money(10_000))
        result.getNumbersCount() shouldBe 10
    }
})
