package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LottoTicketTest : StringSpec({
    "로또 번호가 6개가 아니면 예외가 발생한다" {
        val invalidNumbers = listOf(1, 2, 3, 4, 5)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(invalidNumbers)
        }
    }
    "로또 번호가 1부터 45 사이가 아니면 예외가 발생한다" {
        val invalidNumbers = listOf(1, 2, 3, 4, 5, 46)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(invalidNumbers)
        }
    }
    "로또 번호에 중복이 있으면 예외가 발생한다" {
        val invalidNumbers = listOf(1, 2, 3, 3, 4, 5)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(invalidNumbers)
        }
    }
})
