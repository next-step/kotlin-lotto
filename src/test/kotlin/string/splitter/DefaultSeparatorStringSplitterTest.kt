package string.splitter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import string.converter.ExpressionTokenConverter

internal class DefaultSeparatorStringSplitterTest : StringSpec({
    val sut = DefaultSeparatorStringSplitter(ExpressionTokenConverter())

    "컴마를 분할자로 가지면 숫자 토큰이 분할된 정수형 리스트를 반환한다" {
        sut.split("1,2,3") shouldBe listOf(1, 2, 3)
    }

    "콜론을 분할자로 가지면 숫자 토큰이 분할된 정수형 리스트를 반환한다" {
        sut.split("1:2:3") shouldBe listOf(1, 2, 3)
    }

    "단일 숫자로 이뤄져있으면 단일 숫자를 반환한다" {
        sut.split("999") shouldBe listOf(999)
    }

    "숫자가 아닌 문자를 가지면 예외를 발생시킨다" {
        shouldThrow<RuntimeException> {
            sut.split("1:2:FOO") shouldBe null
        }
    }
})
