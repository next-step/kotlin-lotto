package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoRefereeSpec : FunSpec({
    test("로또 당첨 결과를 산출한다") {
        val winningNumbers = LottoMock.createWinningNumbers()
        val minNumberCountToGetPrize = 3
        val ticketCountByMatchedNumberCount = mapOf(
            0 to 3,
            1 to 3,
            2 to 4,
            3 to 5,
            4 to 6,
            5 to 0,
            6 to 1
        )
        val tickets : List<LottoTicket> = ticketCountByMatchedNumberCount.flatMap { (matchedNumberCount, ticketCount) ->
            List(ticketCount) {
                LottoMock.createTicket(winningNumbers, matchedNumberCount)
            }
        }
        val expect = listOf(LottoResult(3, 5), LottoResult(4, 6),LottoResult(6, 1))

        val result = LottoReferee.createResults(tickets, winningNumbers, minNumberCountToGetPrize)

        result shouldBe expect
    }
})
