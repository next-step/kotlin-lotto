package lotto.vo

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.math.BigDecimal
import java.math.RoundingMode

class MoneyTest : DescribeSpec({

    describe("constructor") {
        context("금액이 0원 이상인 경우") {
            it("금액을 생성한다") {
                listOf(0, 1_000).forAll { amount ->
                    Money.of(amount) shouldNotBe null
                }
            }
        }

        context("금액이 0원 미만일 경우") {
            it("IllegalArgumentException 이 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Money.of(-1)
                }
            }
        }
    }

    describe("add") {
        it("두 금액을 더할 수 있다") {
            Money.of(100) + Money.of(200) shouldBe Money.of(300)
        }
    }

    describe("divide") {
        context("두 금액을 나눌 수 있다") {
            it("(소수점 미 계산)") {
                val target = Money.of(1_000)
                val money = Money.of(300)
                target / money shouldBe 3
            }

            it("(소수점 단위 계산)") {
                val target = Money.of(1_000)
                val money = Money.of(300)
                target.divide(money, 2, RoundingMode.HALF_UP) shouldBe BigDecimal.valueOf(3.33)
            }
        }
    }

    describe("multiply") {
        it("두 금액을 곱할 수 있다") {
            val money = Money.of(100)

            money.multiply(5) shouldBe Money.of(500)
        }
    }

    describe("compareTo") {
        it("두 금액을 비교할 수 있다.") {
            assertSoftly {
                (Money.of(0) == Money.of(0)) shouldBe true
                (Money.of(0) > Money.of(100)) shouldBe false
                (Money.of(0) < Money.of(100)) shouldBe true
            }
        }
    }
})
