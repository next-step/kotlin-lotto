package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class TextParserTest : StringSpec({
    "빈 문자열 또는 null 값을 입력할 경우 빈 리스트로 파싱한다" {
        val testCases: List<String?> = listOf(null, "", " ")

        testCases.forEach { text ->
            val result: List<Int> = TextParser.parse(text)
            result.size shouldBe 0
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자만 담긴 리스트로 파싱한다" {
        val testCases: List<String> = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        testCases.forEach { text ->
            val result: List<Int> = TextParser.parse(text)
            result.size shouldBe 1
            result[0] shouldBe text.toInt()
        }
    }

    "숫자 여러 개를 쉼표와 함께 문자열로 입력하면 쉼표를 기준으로 잘라 숫자를 담은 리스트로 파싱한다" {
        forAll(
            row("1,2", listOf(1, 2)),
            row("1,2,3", listOf(1, 2, 3)),
            row("1,2,3,4", listOf(1, 2, 3, 4)),
        ) { input, expected ->
            val result = TextParser.parse(input)
            result.size shouldBe expected.size
            result shouldBe expected
        }
    }

    "숫자 여러 개를 쉼표와 콜론을 구분자로 한 문자열로 입력하면 각 숫자를 담은 리스트로 파싱한다" {
        forAll(
            row("1:2", listOf(1, 2)),
            row("1,2:3", listOf(1, 2, 3)),
            row("1,2:3,4", listOf(1, 2, 3, 4)),
        ) { input, expected ->
            val result = TextParser.parse(input)
            result.size shouldBe expected.size
            result shouldBe expected
        }
    }

    "//와 \n 문자 사이에 커스텀 구분자를 지정해서 문자열을 숫자 리스트로 파싱할 수 있다." {
        forAll(
            row("//;\n1;2", listOf(1, 2)),
            row("//;\n1,2;3", listOf(1, 2, 3)),
            row("//;\n1;2:3,4", listOf(1, 2, 3, 4)),
        ) { input, expected ->
            val result = TextParser.parse(input)
            result.size shouldBe expected.size
            result shouldBe expected
        }
    }
})
