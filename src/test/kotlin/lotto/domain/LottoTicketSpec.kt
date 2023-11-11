package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTicketSpec : FunSpec({
    test("당첨 번호와 일치하는 수의 갯수를 계산한다") {
        val matchedCount = 3
        val winningNumbers = LottoMock.createWinningNumbers()
        val ticket = LottoMock.createTicketWithDefaultSpec(winningNumbers, matchedCount)

        val result = ticket.countMatched(winningNumbers)

        result shouldBe matchedCount
    }

    test("해당 숫자가 로또 번호에 포함되어 있는지 확인한다") {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        forAll(
            row(1, true),
            row(2, true),
            row(3, true),
            row(4, true),
            row(5, true),
            row(6, true),
            row(7, false),
        ) { number, expect ->
            val result = LottoTicket(numbers).contains(number)

            result shouldBe expect
        }
    }
})
