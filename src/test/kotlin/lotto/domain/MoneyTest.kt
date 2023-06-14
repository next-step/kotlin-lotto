package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import java.math.BigDecimal
import java.math.RoundingMode

class MoneyTest : StringSpec({

    "더하기" {
        val result = Money(1) + Money(2)
        result shouldBe Money(3)
    }

    "빼기" {
        val result = Money(2) - Money(1)
        result shouldBe Money(1)
    }

    "곱하기" {
        val result = Money(2) * Money(3)
        result shouldBe Money(6)
    }

    "나누기" {
        val result = Money(2) / Money(3)
        result shouldBe BigDecimal(0.67).setScale(2, RoundingMode.FLOOR)
    }

    "0으로 나눌 때" {
        shouldThrow<ArithmeticException> { Money(4) / Money(0) }
            .shouldHaveMessage("0으로 나눌 수 없습니다.")
    }
})
