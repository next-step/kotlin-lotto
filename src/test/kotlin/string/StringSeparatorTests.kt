package string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class StringSeparatorTests : StringSpec ({
    "컴마로 구분된 문자열에서 추출된 구분자는 컴마이다" {
        val separatorExtractor = StringSeparator()
        val inputWithComma = "1,2,3"
        val separator = separatorExtractor.separate(inputWithComma)
        separator shouldBe listOf(1,2,3)
    }

    "콜론으로 구분된 문자열에서 추출된 구분자는 콜론이다" {
        val separatorExtractor = StringSeparator()
        val inputWithComma = "1:2:3"
        val separator = separatorExtractor.separate(inputWithComma)
        separator shouldBe listOf(1,2,3)
    }
})