package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class EarningRateSpec : FunSpec({
    context("손해 여부 계산") {
        withData(
            nameFn = { "수익률이 1보다 크거나 같은 ${it.value} 일 경우 손해가 아님" },
            listOf(EarningRate(15.00), EarningRate(1.00)),
        ) { rate ->

            val result = rate.isLoss()

            result shouldBe false
        }

        withData(
            nameFn = { "수익률이 1보다 작은 ${it.value} 일 경우 손해" },
            listOf(EarningRate(0.37), EarningRate(0.00)),
        ) { rate ->

            val result = rate.isLoss()

            result shouldBe true
        }
    }

    context("수익률 생성") {
        test("구매 금액을 수익률로 나눈 값이 수익률") {
            val purchaseAmount = Amount(14000)
            val earningAmount = Amount(5000)

            val result = EarningRate.of(purchaseAmount, earningAmount)

            result shouldBe EarningRate(0.35)
        }
    }
})
