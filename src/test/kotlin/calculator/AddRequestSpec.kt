package calculator

import calcuator.AddRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class AddRequestSpec : FunSpec({
    context("입력값 숫자로 변환") {
        withData(
            nameFn = { "문자열 ${it.first}가 숫자리스트${it.second}로 변환된다" },
            "1" to listOf(1),
            "2" to listOf(2),
        ) {
            val result = AddRequest.from(it.first)

            result.numbers shouldBe it.second
        }
    }

    context("구분자로 숫자 리스트 생성") {
        withData(
            nameFn = { "기본 구분자(쉼표(,), 콜론(:))로 문자열 ${it.first}가 숫자리스트${it.second}로 변환된다" },
            "1,2" to listOf(1, 2),
            "1:2" to listOf(1, 2),
            "1,2:3" to listOf(1, 2, 3)
        ) {
            val result = AddRequest.from(it.first)

            result.numbers shouldBe it.second
        }
    }
})
