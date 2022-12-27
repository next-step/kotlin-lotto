package lotto.common

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberStringTest : StringSpec({

    "숫자 아닐때 에러 발생 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            NumberString("1!")
        }
        exception.message shouldBe "숫자가 아닙니다. (입력값:1!)"
    }

    "빈 문자열 일 때 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            NumberString("")
        }
        exception.message shouldBe "값이 비어있습니다."
    }

    "공백 문자열 일 때 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            NumberString("   ")
        }
        exception.message shouldBe "값이 비어있습니다."
    }
})
