package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TicketCountSpec : FunSpec({
    test("티켓의 배수 금액으로 티켓 수가 생성된다") {
        val count = 3
        val amount = Amount(LottoSpec.PRICE * count)

        val result = TicketCount.from(amount)

        result.value shouldBe count
    }

    test("티켓의 배수 금액이 아닐 경우 티켓 수 생성에 실패한다") {
        val amount = Amount(LottoSpec.PRICE + 1)

        shouldThrow<IllegalArgumentException> {
            TicketCount.from(amount)
        }
    }
})
