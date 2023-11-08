package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketsSpec : FunSpec({
    context("로또 결과 생성") {
        test("로또 결과가가 생성된다") {
            val winningNumbers = LottoMock.createWinningNumbers()
            val ticketCountByMatchedNumberCount = mapOf(
                0 to 1,
                1 to 1,
                2 to 1,
                3 to 2,
                4 to 3,
                5 to 3,
                6 to 1
            )
            val expect = listOf(
                LottoResult(3, 2),
                LottoResult(4, 3),
                LottoResult(5, 3),
                LottoResult(6, 1),
            )
            val tickets =
                ticketCountByMatchedNumberCount.flatMap { (matchedNumberCount, ticketCount) ->
                    List(ticketCount) {
                        LottoMock.createTicketWithDefaultSpec(winningNumbers, matchedNumberCount)
                    }
                }.let(::LottoTickets)

            val result = tickets.determinePrize(winningNumbers)

            result shouldBe expect.let(::LottoResults)
        }
    }

    context("로또 가격 계산") {
        test("가격이 주어지면 구입한 총 가격이 계산된다") {
            val price = Amount(1000)
            val count = 3
            val tickets = LottoTickets(List(count) { LottoMock.createTickets() } )

            val result = tickets.calculatePrice(price)

            result shouldBe price * count
        }
    }

    context("티켓의 수를 센다") {
        val count = 3
        val tickets = LottoTickets(List(count) { LottoMock.createTickets() } )

        val result = tickets.count()

        result shouldBe count
    }
})
