package stringsumcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class StringNumbersTest : StringSpec({
    "기본 구분자로 이루어진 문자열을 숫자로 분리한다" {
        val numbers = StringNumbers("1:2,3")

        val actual = numbers.toList()

        actual shouldContainExactly listOf(
            StringNumber("1"),
            StringNumber("2"),
            StringNumber("3")
        )
    }

    "커스텀 구분자와 기분 구분자로 이루어진 문자열을 숫자로 분리한다" {
        val numbers = StringNumbers("//;\n1:2,3;4")

        val actual = numbers.toList()

        actual shouldContainExactly listOf(
            StringNumber("1"),
            StringNumber("2"),
            StringNumber("3"),
            StringNumber("4"),
        )
    }
})
