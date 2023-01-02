package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Cash
 */
class CashTest : FunSpec({

    context("Cash") {
        val cash = Cash(1000)

        test("fun buy()") {
            val price = 1000
            val count = cash.buy(price)

            count shouldBe 1
        }

        test("subtract") {
            cash.subtract(cash) shouldBe Cash(0)
        }
    }
})
