package calculator

import calcuator.Splitter
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class SplitterSpec : FunSpec({
    context("단일 문자열 변환") {
        withData(
            nameFn = { "단일 문자열 ${it}가 문자열리스트로 변환된다" },
            "1",
            "2",
        ) {
            val result = Splitter.split(it)

            result shouldBe listOf(it)
        }
    }

    context("구분자로 숫자 리스트 생성") {
        withData(
            nameFn = { "기본 구분자(쉼표(,), 콜론(:))와 커스텀 구분자로 문자열 ${it.first}이 문자리스트${it.second}로 변환된다" },
            "1,2" to listOf("1", "2"),
            "1:2" to listOf("1", "2"),
            "//;\n1;2" to listOf("1", "2"),
            "//;\n1;2,3:4" to listOf("1", "2", "3", "4"),
            "//;\n1;2;;3:4,!" to listOf("1", "2", "", "3", "4", "!"),
        ) {
            val result = Splitter.split(it.first)

            result shouldBe it.second
        }
    }
})
