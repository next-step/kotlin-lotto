package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoShopSpec : FunSpec({
    context("로또 구매") {
        val lottoPLice = Amount(1000)
        val shop = LottoShop(price = lottoPLice)
        test("로또 배수 금액으로 구매") {
            val count = 3
            val amount = lottoPLice * 3

            val tickets = shop.purchase(amount)

            tickets.count shouldBe count
        }

        test("로또의 배수 금액이 아닐 때 구매 실패") {
            val amount = lottoPLice + Amount(1)

            shouldThrow<IllegalArgumentException> {
                shop.purchase(amount)
            }
        }
    }

    context("티켓의 결과를 도출") {
        val lottoPLice = Amount(1000)
        val shop = LottoShop(price = lottoPLice)
        val winningLotto = WinningLotto(LottoTicket(listOf(1, 2, 3, 4, 5, 6)), 7)
        val nonMatchedTicket = LottoTicket(listOf(8, 9, 10, 11, 12, 13))
        val fifthRankTicket = LottoTicket(listOf(1, 2, 3, 43, 44, 45))
        val secondRankTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 7))
        val purchasedTickets = List(12) { nonMatchedTicket } + listOf(fifthRankTicket, secondRankTicket)
        val tickets = LottoTickets(purchasedTickets)

        val result = shop.receivePrize(tickets, winningLotto)


        test("통계 생성") {
            result.rankCounts shouldBe mapOf(LottoRank.MISS to 12, LottoRank.SECOND to 1, LottoRank.FIFTH to 1).let(::LottoRankCounts)
        }

        test("수익률 계산") {
            result.earningRate shouldBe EarningRate(2143.21)
        }
    }
})
