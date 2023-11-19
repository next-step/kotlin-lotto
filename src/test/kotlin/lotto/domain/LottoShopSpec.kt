package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.error.InvalidLottoAmountException

class LottoShopSpec : FunSpec({
    context("로또 구매") {
        val lottoPrice = Amount(1000)
        val shop = LottoShop(price = lottoPrice)
        val count = 3
        val manualLottoNumbers =
            listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(listOf(11, 12, 13, 14, 15, 16)))
        test("로또 배수(${count}배수) 금액(3_0000), 수동 로또 번호 $manualLottoNumbers 로 구매") {
            val amount = Amount(3000)

            val ticket = shop.purchase(amount, manualLottoNumbers)

            ticket.count shouldBe count
            ticket.numbers shouldContainAll manualLottoNumbers
        }

        test("로또의 배수 금액이 아닐 때(30_001) 구매 실패") {
            val amount = Amount(30001)

            shouldThrow<InvalidLottoAmountException> {
                shop.purchase(amount, emptyList())
            }
        }
    }

    context("티켓의 결과를 도출") {
        val lottoPLice = Amount(1000)
        val shop = LottoShop(price = lottoPLice)
        val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 7)
        val nonMatchedNumber = LottoNumber(listOf(8, 9, 10, 11, 12, 13))
        val fifthRankNumber = LottoNumber(listOf(1, 2, 3, 43, 44, 45))
        val secondRankNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 7))
        val ticket = LottoTicket(List(12) { nonMatchedNumber } + listOf(fifthRankNumber, secondRankNumber))

        val result = shop.receivePrize(ticket, winningLotto)

        test("2등 1장, 5등 1장, 당첨 안된 12장에 대한 통계 생성") {
            result.rankCounts shouldBe mapOf(
                LottoRank.MISS to 12,
                LottoRank.FIFTH to 1,
                LottoRank.SECOND to 1
            ).let(::LottoRankCounts)
        }

        test("총상금(30_005_000)을 구매 금액(14_000)으로 나눈 수익률(2143.21) 계산") {
            result.earningRate shouldBe EarningRate(2143.21)
        }
    }
})
