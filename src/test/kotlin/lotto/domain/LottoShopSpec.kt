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

    context("수익률 계산") {
        val lottoPLice = Amount(1000)
        val shop = LottoShop(price = lottoPLice)

        test("테스트") {
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val bonusNumber = 7
            val tickets = LottoTickets(
                tickets = List(13) {
                    LottoTicket(listOf(8, 9, 10, 11, 12, 13))
                } + listOf(LottoTicket(listOf(1, 2, 3, 43, 44, 45))),
                _result = LottoResult(
                    mapOf(LottoRank.FIFTH to 1)
                ))

            val result = shop.calculateEarningRatioOf(tickets, WinningLotto(LottoTicket(numbers), bonusNumber))

            result shouldBe EarningRate(0.35)
        }
    }
})
