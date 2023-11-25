package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.error.InvalidLottoAmountException

class LottoPurchaseAmountSpec : DescribeSpec({
    describe("LottoPurchaseAmount()") {
        context("로또 배수 금액") {
            val lottoPrice = Amount(1000)
            val amount = lottoPrice * 5

            it("로또 구매 금액 생성") {
                val result = LottoPurchaseAmount(amount, lottoPrice)

                result.purchaseAmount shouldBe amount
                result.lottoPrice shouldBe lottoPrice
            }
        }

        context("로또 배수가 아닌 금액") {
            val lottoPrice = Amount(1000)
            val amount = Amount(1200)

            it("로또 구매 금액 생성 실패") {
                shouldThrow<InvalidLottoAmountException> {
                    LottoPurchaseAmount(amount, lottoPrice)
                }
            }
        }
    }

    describe("purchasedCount") {
        val count = 5
        context("로또 가격의 ${count}배의 금액으로 구매") {
            val lottoPrice = Amount(1000)
            val amount = lottoPrice * count
            val purchaseAmount = LottoPurchaseAmount(amount, lottoPrice)

            it("구매 개수는 $count") {
                purchaseAmount.purchasedCount shouldBe count
            }
        }
    }
})
