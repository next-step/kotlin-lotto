package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketSpec : FunSpec({
    context("로또 가격 계산") {
        test("가격이 주어지면 구입한 총 가격이 계산된다") {
            val price = Amount(1000)
            val count = 3
            val ticket = LottoTicket(List(count) { LottoMock.createTicket() })

            val result = ticket.calculatePrice(price)

            result shouldBe price * count
        }
    }

    context("티켓의 수를 센다") {
        val count = 3
        val ticket = LottoTicket(List(count) { LottoMock.createTicket() })

        val result = ticket.count

        result shouldBe count
    }

    context("티켓의 결과를 도출") {
        test("로또 결과가 생성된다") {
            val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 7)
            val expect = mapOf(
                LottoRank.FIRST to 1,
                LottoRank.SECOND to 1,
                LottoRank.THIRD to 2,
                LottoRank.FOURTH to 2,
                LottoRank.FIFTH to 1,
                LottoRank.MISS to 1,
            )
            val ticket = expect.flatMap { (rank, ticketCount) ->
                List(ticketCount) {
                    LottoMock.createTicket(winningLotto, rank.countOfMatch, rank.isWithBonusMatch)
                }
            }.let(::LottoTicket)

            val result = ticket determineResultBy winningLotto

            result.value shouldBe expect
        }
    }
})
