package calculator

import calculator.parser.TextParser
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TextParserTest : StringSpec({
    val sut = TextParser

    "문자열을 입력받으면 구분자를 기준으로 숫자들을 분리한다" {
        val text = "1,2:3"

        val actual = sut.parse(text)

        actual shouldBe listOf(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3))
    }

    "커스텀 구분자가 있는 경우 커스텀 구분자를 기준에 추가하여 숫자들을 분리한다" {
        val text = "//;\n1;2;3"

        val actual = sut.parse(text)

        actual shouldBe listOf(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3))
    }

    "문자열이 비어있는 경우 빈 리스트를 반환한다" {
        val text = ""

        val actual = sut.parse(text)

        actual shouldBe listOf()
    }

    "문자열이 null인 경우 빈 리스트를 반환한다" {
        val text = null

        val actual = sut.parse(text)

        actual shouldBe listOf()
    }
})
