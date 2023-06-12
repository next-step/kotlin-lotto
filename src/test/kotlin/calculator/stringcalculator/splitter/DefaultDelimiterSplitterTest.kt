package calculator.stringcalculator.splitter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DefaultDelimiterSplitterTest : FunSpec({
    test("기본 구분자 ,, :으로 문자열을 분리할 수 있다.") {
        listOf("1,2,3", "1:2:3", "1,2:3", "1:2,3").forEach {
            val expected = listOf("1", "2", "3")
            val actual = DefaultDelimiterSplitter.split(it)

            actual shouldBe expected
        }
    }

    test("공백을 전달하면 그대로 공백을 반환한다.") {
        val actual = DefaultDelimiterSplitter.split("")

        actual shouldBe emptyList()
    }
})
