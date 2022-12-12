package lotto.application.common

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.common.Number
import lotto.common.NumberStringList

class NumberStringListTest : StringSpec({

    "숫자 아닐때 에러 발생 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            NumberStringList("1,a")
        }
        exception.message shouldBe "숫자가 아닙니다. (입력값:a)"
    }

    "빈 문자열 일 때 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            NumberStringList("1,")
        }
        exception.message shouldBe "값이 비어있습니다."
    }

    "공백 문자열 일 때 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            NumberStringList("1,   ")
        }
        exception.message shouldBe "값이 비어있습니다."
    }

    "숫자 리스트 변환 테스트" {
        // given
        val numberStringList = NumberStringList("1,2,3,4,5")
        // when
        val numberList = numberStringList.toNumberList()
        // then
        numberList shouldBe listOf(Number(1), Number(2), Number(3), Number(4), Number(5))
    }
})
