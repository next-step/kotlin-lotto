package string

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class ExpressionTokenConverterTest : StringSpec({
    val sut = ExpressionTokenConverter()

    "토큰을 Int 자료형으로 변환한다" {
        sut.convert("1") shouldBe 1
    }

    "토큰이 숫자가 아니라면 예외를 발생시킨다" {
        shouldThrow<RuntimeException> {
            sut.convert("a")
        }
    }

    "토큰이 음수라면 예외를 발생시킨다" {
        shouldThrow<RuntimeException> {
            sut.convert("-1")
        }
    }
})