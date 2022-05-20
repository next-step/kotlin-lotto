package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringSeparatorTest : StringSpec({
    "기본 구분자 문자열을 구분할수 있다." {
        val defaultDelimiter = mapOf(
            "1,2,3" to positiveNumbers,
            "1:2,3" to positiveNumbers
        )

        defaultDelimiter.forAll {
            StringSeparator.separate(it.key) shouldBe it.value
        }

    }

    "입력값이 비었거나 null인 경우 기본 값을 반환한다." {
        listOf("", null).forAll {
            StringSeparator.separate(it) shouldBe PositiveNumbers(listOf(PositiveNumber(0)))
        }
    }

    "커스텀 구분자를 사용하여 문자열을 구분할 수 있다." {
        val customDelimiter = mapOf(
            "//;\n1;2;3" to positiveNumbers,
            "//#\n1#2#3" to positiveNumbers
        )

        customDelimiter.forAll {
            StringSeparator.separate(it.key) shouldBe it.value
        }
    }

    "숫자가 아닌값이 입력되는 경우 Exception을 던진다." {
        listOf("1,2,a", "a", "//;\n1;e;3").forAll {
            shouldThrow<IllegalArgumentException> { StringSeparator.separate(it) }
        }
    }
}) {
    companion object {
        private val positiveNumbers = PositiveNumbers(listOf(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3)))
    }
}
