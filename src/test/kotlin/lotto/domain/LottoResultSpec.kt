package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoResultSpec : FunSpec({
    context("당첨로또, 구매 로또, 티켓 가격으로 로또 결과가 생성된다") {
        val winningLotto = WinningLotto(LottoTicket(listOf(1, 2, 3, 4, 5, 6)), 7)
        val nonMatchedTicket = LottoTicket(listOf(8, 9, 10, 11, 12, 13))
        val fourthRankTicket = LottoTicket(listOf(1, 2, 3, 4, 44, 45))
        val tickets = LottoTickets(List(9) { nonMatchedTicket } + listOf(fourthRankTicket))
        val price = Amount(1000)

        val result = LottoResult.of(winningLotto, tickets, price)

        test("통계 생성") {
            result.rankCounts shouldBe mapOf(LottoRank.MISS to 9, LottoRank.FOURTH to 1).let(::LottoRankCounts)
        }

        test("수익률 계산") {
            result.earningRate shouldBe EarningRate(5.00)
        }
    }
})
