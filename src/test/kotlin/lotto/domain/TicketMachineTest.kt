package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.TicketMachine.exchange

class TicketMachineTest : StringSpec({
    "구입금액을 입력하면 티켓 카운트를 반환한다" {
        exchange(Money(2000)).size shouldBe 2
    }

    "금액을 1,000원단위로 하지 않을 시 예외 발생한다" {
        listOf(1100, 1200, 3500, 12310, 1500).forAll { amount ->
            shouldThrow<IllegalArgumentException> { exchange(Money(amount)) }
        }
    }

    "금액을 1,000원 미만으로 입력시 시 예외 발생한다" {
        listOf(100, 200, 1, 10, 300, 900).forAll { amount ->
            shouldThrow<IllegalArgumentException> { exchange(Money(amount)) }
        }
    }
})
