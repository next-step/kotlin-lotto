package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class AmountSpec : FunSpec({
    context("금액 생성") {
        test("금액이 생성된다") {
            val amount = 1000

            val result = Amount(amount)

            result.value shouldBe amount
        }

        test("0보다 크지 않은 수로 금액 생성시 생성에 실패한다") {
            val amount = -100

            shouldThrow<IllegalArgumentException> {
                Amount(amount)
            }
        }
    }

    context("수익률 계산") {
        test("구매 금액과 비교한 수익률이 계산된다") {
            val purchaseAmount = Amount(14000)
            val prizeAmount = Amount(5000)

            val result = prizeAmount.calculateEarningRate(purchaseAmount)

            result shouldBe EarningRate(0.35)
        }
    }

    context("상품 구매 수 계산") {
        test("상품의 배수 금액으로 상품 수가 생성된다") {
            forAll(
                row(Amount(1000)),
                row(LottoSpec.PRICE),
            ) { productPrice ->
                val count = 3
                val amount = productPrice * count

                val result = amount.purchase(productPrice)

                result.value shouldBe count
            }
        }

        test("상품의 배수 금액이 아닐 경우 상품 수 생성에 실패한다") {
            val amount = LottoSpec.PRICE + Amount(1)

            shouldThrow<IllegalArgumentException> {
                amount.purchase(LottoSpec.PRICE)
            }
        }
    }
})
