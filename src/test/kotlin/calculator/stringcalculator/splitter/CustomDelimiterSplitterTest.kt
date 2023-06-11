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

    test("유효한 커스텀 구분자가 있을 경우 분리자 지원이 가능하다.") {
        CustomDelimiterSplitter.supported("//;\n1;2;3") shouldBe true
    }

    test("유효한 커스텀 구분자가 없을 경우 분리자 지원이 불가하다.") {
        listOf("1,2,3", "1:2:3", "//\n123", "//1\n11213").forEach {
            val actual = CustomDelimiterSplitter.supported(it)

            actual shouldBe false
        }
    }
})
