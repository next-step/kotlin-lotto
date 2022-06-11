package lotto.dto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class TicketCountDtoTest : DescribeSpec({
    it("로또 갯수 입력 받아서 보관한다 ") {
        // given
        val ticketCountString = "3"

        // when
        val ticketCountDto = TicketCountDto(ticketCountString)

        // then
        ticketCountDto.tickCount shouldBe 3
    }

    describe("validation 검사") {
        it("문자를 입력시 IllegalArgumentException 발생") {
            // given
            val illegalArgumentString = "VALIDATION_TEST"

            // then
            shouldThrowExactly<IllegalArgumentException> {
                TicketCountDto(illegalArgumentString)
            }.shouldHaveMessage("정수만을 입력해주세요.(입력값: $illegalArgumentString)")
        }

        it("소수 입력시 IllegalArgumentException 발생") {
            // given
            val illegalArgumentString = "0.11"

            // then
            shouldThrowExactly<IllegalArgumentException> {
                TicketCountDto(illegalArgumentString)
            }.shouldHaveMessage("정수만을 입력해주세요.(입력값: $illegalArgumentString)")
        }

        it("음수 입력시 IllegalArgumentException 발생") {
            // given
            val illegalArgumentString = "-1"

            // then
            shouldThrowExactly<IllegalArgumentException> {
                TicketCountDto(illegalArgumentString)
            }.shouldHaveMessage("정수만을 입력해주세요.(입력값: $illegalArgumentString)")
        }
    }
})
