package calculator.stringcalculator.splitter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CustomDelimiterSplitterTest : FunSpec({
    test("유효한 커스텀 구분자로 문자열을 분리할 수 있다.") {
        val actual = CustomDelimiterSplitter.split("//;\n1;2;3")

        actual shouldBe listOf("1", "2", "3")
    }

    test("유효하지 않은 커스텀 구분자는 예외를 던진다.") {
        listOf("1,2,3", "1:2:3", "//\n123", "//1\n11213").forEach {
            shouldThrow<IllegalArgumentException> {
                CustomDelimiterSplitter.split(it)
            }
        }
    }
})
