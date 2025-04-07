package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class MoneyTest : FunSpec({
    context("create") {
        test("value must be between 0 and 100,000") {
            listOf(0, 1_000, 10_000, 50_000, 100_000).forAll {
                shouldNotThrowAny {
                    Money(it)
                }
            }
        }

        test("throw exception if value is less than 0 or above 100,000") {
            listOf(-1, 100_001).forAll {
                shouldThrow<IllegalArgumentException> {
                    Money(it)
                }
            }
        }
    }

    context("divide") {
        test("divide by zero does not throw exception") {
            Money(1_000) / BigDecimal(0) shouldBe Money(0)
        }

        test("performs as expected") {
            Money(10_000) / BigDecimal(2) shouldBe Money(5_000)
        }

        test("performs with rounding down") {
            Money(10_000) / BigDecimal(3) shouldBe Money(3_333)
        }
    }

    context("minus") {
        test("performs as expected") {
            Money(10_000) - BigDecimal(5_000) shouldBe Money(5_000)
        }

        test("throws exception if result is negative") {
            shouldThrow<IllegalStateException> {
                Money(1_000) - BigDecimal(1_001)
            }
        }
    }
})
