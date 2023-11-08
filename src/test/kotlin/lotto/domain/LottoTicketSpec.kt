package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketSpec : FunSpec({
    test("당첨 번호와 일치하는 수의 갯수를 계산한다") {
        val matchedCount = 3
        val winningNumbers = LottoMock.createWinningNumbers()
        val ticket = LottoMock.createTicketWithDefaultSpec(winningNumbers, matchedCount)

        val result = ticket.countMatched(winningNumbers)

        result shouldBe matchedCount
    }
})
