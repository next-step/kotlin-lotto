package lotto.application.common

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.common.Number
import lotto.common.NumberString

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

    "양수 판단 테스트" {
        // given
        val number = Number(1)
        // when
        val actual = number.isPositive()
        // then
        actual shouldBe true
    }

    "음수 판단 테스트" {
        // given
        val number = Number(-1)
        // when
        val actual = number.isNegative()
        // then
        actual shouldBe true
    }

    "double 타입으로 변환 테스트" {
        // given
        val number = Number(1)
        // when
        val actual = number.toDouble()
        // then
        actual shouldBe 1.0
    }
})