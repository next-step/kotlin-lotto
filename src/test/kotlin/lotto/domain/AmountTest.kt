package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class AmountTest : FunSpec({
    test("value must be above or equal to 1,000 and below or equal to 100,000") {
        listOf(
            1_000,
            2_000,
            10_000,
            100_000,
        ).forAll {
            shouldNotThrowAny {
                Amount(it)
            }
        }
    }

    test("throw exception if value is less than 0 or above 100,000") {
        listOf(
            -2,
            -1,
            100_001,
            100_002,
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                Amount(it)
            }
        }
    }

    context("countPurchasable") {
        val amountValue = 10_000
        val amount = Amount(amountValue)

        test("divide by zero does not throw exception") {
            val price = 1_000
            listOf(1_000, 2_000, 2_500, 3_300).forAll {
                amount.countPurchasable(price) shouldBe amountValue / price
            }
        }
    }

    context("spend") {
        test("deduct given amount from balance") {
            listOf(1_000, 2_000, 5_000, 100_000).forAll {
                shouldNotThrowAny {
                    Amount(100_000).spend(it)
                }
            }
        }

        test("should throw exception if spend amount is greater than given value") {
            shouldThrow<IllegalStateException> {
                Amount(1_000).spend(1_001)
            }
        }
    }
})
