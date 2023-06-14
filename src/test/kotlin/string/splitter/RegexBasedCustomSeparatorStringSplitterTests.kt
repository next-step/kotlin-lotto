package string.splitter

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import string.converter.ExpressionTokenConverter
import string.splitter.RegexBasedCustomSeparatorStringSplitter

class RegexBasedCustomSeparatorStringSplitterTests : StringSpec ({
    "문자열이 커스텀 구분자를 가지면 숫자 토큰이 분할된 정수형 리스트를 반환한다" {
        val splitter = RegexBasedCustomSeparatorStringSplitter(ExpressionTokenConverter())
        val input = "//;\n1;2;3"
        splitter.split(input) shouldBe listOf(1,2,3)
    }

    "문자열이 커스텀 구분자를 가지지 않으면 null 을 반환한다" {
        val splitter = RegexBasedCustomSeparatorStringSplitter(ExpressionTokenConverter())
        val input = "1,2,3"
        splitter.split(input) shouldBe null
    }
})