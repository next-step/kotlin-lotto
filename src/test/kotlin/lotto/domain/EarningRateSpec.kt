package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class EarningRateSpec : FunSpec({
    test("수익률에 따라 손해 여부가 반환된다") {
        forAll(
            row(15.00, false),
            row(1.00, false),
            row(0.35, true),
        ) { rate, expect ->
            val earningRate = EarningRate(rate)

            val result = earningRate.isLoss()

            result shouldBe expect
        }
    }

    context("수익률 생성") {
        test("구매 금액과 비교한 수익률이 계산된다") {
            val purchaseAmount = Amount(14000)
            val earningAmount = Amount(5000)

            val result = EarningRate.of(purchaseAmount, earningAmount)

            result shouldBe EarningRate(0.35)
        }
    }
})
