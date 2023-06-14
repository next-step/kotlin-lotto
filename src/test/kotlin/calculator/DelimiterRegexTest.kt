package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DelimiterRegexTest : StringSpec({
    "기본 Delimiter 는 의 정규식은 ',' 와 ':' 로 이루어져 있다" {
        val defaultRegex = DelimiterRegex.DEFAULT.regex
        defaultRegex shouldBe "[:,]".toRegex()
    }

    "Custom Delimiter 정규식은 prefix 가 '//' 이고 suffix 가 '\"n' 이다" {
        val customRegex = DelimiterRegex.CUSTOM.regex
        customRegex shouldBe "//.*\\n".toRegex()
    }
})
