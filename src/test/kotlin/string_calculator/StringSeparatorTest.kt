package string_calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSeparatorTest : StringSpec({
    "커스텀 연산자를 가지는 수식을 연산자와 수식으로 나눈다" {
        // given
        val text = "//;\n1;2;3"

        // when
        val (delimiters, expression) = StringSeparator.splitToDelimitersAndNumbers(text)

        // then
        delimiters.size shouldBe 3
        delimiters shouldBe listOf(",", ":", ";")
        expression shouldBe "1;2;3"
    }

    "커스텀 연산자를 가지지 않는 수식을 연산자와 수식으로 나눈다" {
        // given
        val text = "1,2,3"

        // when
        val (delimiters, expression) = StringSeparator.splitToDelimitersAndNumbers(text)

        // then
        delimiters.size shouldBe 2
        delimiters shouldBe listOf(",", ":")
        expression shouldBe "1,2,3"
    }
})
