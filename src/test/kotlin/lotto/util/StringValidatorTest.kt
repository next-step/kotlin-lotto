package lotto.util

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringValidatorTest : StringSpec({
    "숫자 아닐때 에러 발생 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            StringValidator.validateNumber("1!")
        }
        exception.message shouldBe "숫자가 아닙니다. (입력값:1!)"
    }

    "빈 문자열 일 때 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            StringValidator.validateNotBlank("")
        }
        exception.message shouldBe "값이 비어있습니다."
    }

    "공백 문자열 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            StringValidator.validateNotBlank("  ")
        }
        exception.message shouldBe "값이 비어있습니다."
    }
})
