package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.error.InvalidLottoCountException

class LottoShopSpec : DescribeSpec({
    describe("toLottoPurchaseAmount") {
        val lottoPrice = Amount(1000)
        val shop = LottoShop(lottoPrice)
        val count = 3
        val amount = lottoPrice * count

        context("로또 가격이 ($lottoPrice) 가게, 구매 금액은 로또 가격 배수의 금액 ($amount)") {
            val result = shop.toLottoPurchaseAmount(amount)

            it("생성된 구매 금액의 로또 가격 ($lottoPrice)") {
                result.lottoPrice shouldBe lottoPrice
            }

            it("생성된 구매 금액의 로또 구매 금액 ($amount)") {
                result.purchaseAmount shouldBe amount
            }
        }
    }

    describe("purchase") {
        val lottoPrice = Amount(1000)
        val shop = LottoShop(price = lottoPrice)
        val count = 3
        val purchaseAmount = LottoPurchaseAmount(lottoPrice * count, lottoPrice)
        val manualLottoNumbers =
            listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(listOf(11, 12, 13, 14, 15, 16)))
        context("로또 배수($count 배) 금액(${purchaseAmount.purchaseAmount}), 수동 로또 번호 $manualLottoNumbers 로 구매") {
            val ticket = shop.purchase(purchaseAmount, manualLottoNumbers)

            it("로또 구매 수는 $count") {
                ticket.count shouldBe count
            }

            it("로또 구매 번호는 수동 로또 번호 포함") {
                ticket.numbers shouldContainAll manualLottoNumbers
            }
        }

        val manualLottoCount = 2
        val lottoCount = 1
        context("수동 로또 번호의 수($manualLottoCount)가 구매 로또 번호 수($lottoCount)보다 클 때") {
            val lottoPrice = Amount(1000)
            val shop = LottoShop(price = lottoPrice)
            val purchaseAmount = LottoPurchaseAmount(lottoPrice * lottoCount, lottoPrice)
            val manualLottoNumbers = List(manualLottoCount) { LottoNumber(listOf(1, 2, 3, 4, 5, 6)) }

            it("구매 실패") {
                shouldThrow<InvalidLottoCountException> {
                    shop.purchase(purchaseAmount, manualLottoNumbers)
                }
            }
        }
    }

    describe("receivePrize") {
        val lottoPLice = Amount(1000)
        val shop = LottoShop(price = lottoPLice)

        context("2등 1장, 5등 1장, 당첨 안된 12장 (총 14장)에 대한 티켓") {
            val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 7)
            val nonMatchedNumber = LottoNumber(listOf(8, 9, 10, 11, 12, 13))
            val fifthRankNumber = LottoNumber(listOf(1, 2, 3, 43, 44, 45))
            val secondRankNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 7))
            val ticket = LottoTicket(List(12) { nonMatchedNumber } + listOf(fifthRankNumber, secondRankNumber))
            val result = shop.receivePrize(ticket, winningLotto)

            it("2등 1장, 5등 1장, 당첨 안된 12장에 대한 통계 생성") {
                result.rankCounts shouldBe mapOf(
                    LottoRank.MISS to 12,
                    LottoRank.FIFTH to 1,
                    LottoRank.SECOND to 1
                ).let(::LottoRankCounts)
            }

            it("총상금(30_005_000)을 구매 금액(14_000)으로 나눈 수익률(2143.21) 계산") {
                result.earningRate shouldBe EarningRate(2143.21)
            }
        }
    }
})
