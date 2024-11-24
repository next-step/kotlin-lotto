package lottery.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lottery.domain.TicketMachine.exchange

class TicketMachineTest : StringSpec({
    "구입금액을 입력하면 티켓 카운트를 반환한다" {
        exchange(Money(2000)).size shouldBe 2
    }

    "금액을 1,000원단위로 하지 않을 시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            exchange(Money(1500))
        }
    }

    "금액을 1,000원 미만으로 입력시 시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            exchange(Money(900))
        }
    }
})
