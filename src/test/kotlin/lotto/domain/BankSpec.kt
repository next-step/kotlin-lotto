package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BankSpec : FunSpec({
    test("티켓 구매 금액이 저장된다") {
        forAll(
            row(Amount(0), Amount(1000)),
            row(Amount(1000), Amount(2000)),
        ) { initialRevenue, amountToAdd ->
            val bank = Bank(initialRevenue)

            val result = bank.save(amountToAdd)

            result shouldBe initialRevenue + amountToAdd
        }
    }

    context("상금 수령") {
        test("상금을 수령하면 수익률이 계산된다") {
            val purchaseAmount = Amount(14000)
            val bank = Bank(purchaseAmount)
            val prizeAmount = Amount(5000)

            val result = bank.receivePrize(prizeAmount)

            result shouldBe 0.35
        }
    }
})
