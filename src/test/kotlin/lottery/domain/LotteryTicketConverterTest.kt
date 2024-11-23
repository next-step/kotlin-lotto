package lottery.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lottery.domain.LotteryTicketConverter.convertToTickets

class LotteryTicketConverterTest : StringSpec({
    "구입금액을 입력하면 티켓 카운트를 반환한다" {
        convertToTickets(Money(2000)).size shouldBe 2
    }

    "금액을 1,000원단위로 하지 않을 시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            convertToTickets(Money(1500))
        }
    }

    "금액을 1,000원 미만으로 입력시 시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            convertToTickets(Money(900))
        }
    }
})
