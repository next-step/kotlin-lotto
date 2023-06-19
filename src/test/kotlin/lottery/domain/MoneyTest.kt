package lottery.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class MoneyTest : FunSpec({

    context("init") {
        test("돈은 음수가 입력될 경우 예외가 발생한다") {
            val exception = shouldThrowExactly<IllegalArgumentException> { Money(value = BigDecimal(-1)) }
            exception.message shouldBe "돈은 음수가 입력될 수 없다"
        }
    }

    context("isDivisible") {
        test("나누어 떨어지는지 확인한다") {
            forAll(
                row(Money(value = BigDecimal(999)), false),
                row(Money(value = BigDecimal(1_999)), false),
                row(Money(value = BigDecimal(1_000)), true),
            ) { input, expected ->
                val actual = input.isDivisible(Money(value = BigDecimal(1_000)))
                actual shouldBe expected
            }
        }
    }

    context("divide") {
        test("나눈 몫을 나머지를 버리고 반환한다") {
            val actual = Money(value = BigDecimal(3_600)).divide(Money(value = BigDecimal(1_000)))
            actual shouldBe BigDecimal(3)
        }
    }

    context("plus") {
        test("money를 더한다") {
            val actual = Money(value = BigDecimal(3_600)) + Money(value = BigDecimal(1_000))
            actual shouldBe Money(value = BigDecimal(4_600))
        }
    }
})
