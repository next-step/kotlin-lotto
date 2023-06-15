package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MoneyTest : FunSpec({
    test("유효한 자연수를 전달하면 돈 객체가 생성된다.") {
        listOf(0L, 1L, 10L, 100L, 1000L, 10000L, 10000L, Long.MAX_VALUE).forEach {
            val actual = Money(it)

            actual.value shouldBe it
        }
    }

    test("유효한 문자열을 전달하면 돈 객체가 생성된다.") {
        listOf("0", "100", "1000", "99999", "1000000").forEach {
            val actual = Money.from(it)

            actual.value shouldBe it.toInt()
        }
    }

    test("유효하지 않은 인자를 전달하면 예외를 던진다.") {
        listOf(-1L, -100L, Long.MIN_VALUE).forEach {
            shouldThrow<IllegalArgumentException> { Money(it) }
        }

        listOf("-1", "a", "invalidvalue", "").forEach {
            shouldThrow<IllegalArgumentException> { Money.from(it) }
        }
    }
})
