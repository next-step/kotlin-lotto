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
            val (rest, count) = cash.buy(price)

            rest shouldBe Cash(0)
            count shouldBe 1
        }

        test("subtract") {
            cash.subtract(cash) shouldBe Cash(0)
        }
    }
})
