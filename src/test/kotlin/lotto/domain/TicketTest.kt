package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TicketTest : DescribeSpec({
    describe("init 메서드 테스트") {
        context("로또 숫자가 6개가 주어질 때") {
            it("객체를 성공적으로 생성한다.") {
                val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5, 6)
                val ticket = Ticket(givenNumbers)

                ticket.numbers shouldBe givenNumbers
            }
        }

        context("로또 숫자가 6개 이상 주어질 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5, 6, 7)
                    Ticket(givenNumbers)
                }
                exception.message shouldBe "6자리 로또 티켓을 입력해주세요."
            }
        }

        context("로또 숫자가 6개 미만 주어질 때") {
            it("예외를 던진다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    val givenNumbers: Set<Int> = setOf(1, 2, 3, 4, 5)
                    Ticket(givenNumbers)
                }
                exception.message shouldBe "6자리 로또 티켓을 입력해주세요."
            }
        }
    }
})
