package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class LottoTicketTest : StringSpec({
    "로또 티켓은 6개의 번호를 가진다" {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val sut = LottoTicket(numbers)

        sut.numbers.size shouldBe 6
        sut.numbers shouldContainExactly listOf(1, 2, 3, 4, 5, 6)
    }

    "로또 티켓은 6개 미만의 번호를 받으면 예외를 던진다" {
        val numbers = listOf(1, 2, 3, 4, 5)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }

    "로또 티켓은 6개 초과한 번호를 받으면 예외를 던진다" {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }
})
