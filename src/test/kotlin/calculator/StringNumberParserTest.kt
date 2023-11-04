package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringNumberParserTest : FunSpec({
    val stringNumberParser = StringNumberParser()

    context("입력 문자열의 커스텀 구분자 추출 테스트") {
        test("단일 문자 커스텀 구분자 입력 시 정상 반환") {
            val separator = "!"
            val input = """//$separator\n"""

            val result = stringNumberParser.getCustomSeparator(input)

            result shouldBe separator
        }

        test("공백 커스텀 구분자 입력 시 정상 반환") {
            val separator = " "
            val input = """//$separator\n"""

            val result = stringNumberParser.getCustomSeparator(input)

            result shouldBe separator
        }

        test("백 슬래쉬 커스텀 구분자 입력 시 정상 반환") {
            val separator = "\\"
            val input = """//$separator\n"""

            val result = stringNumberParser.getCustomSeparator(input)

            result shouldBe separator
        }

        test("2자 이상 문자 커스텀 구분자 입력 시 null 반환") {
            val separator = "//"
            val input = """//$separator\n"""

            val result = stringNumberParser.getCustomSeparator(input)

            result shouldBe null
        }
    }
})
