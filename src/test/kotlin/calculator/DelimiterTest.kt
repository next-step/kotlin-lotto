package calculator

import calculator.application.parser.model.DelimiterEnum
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DelimiterTest : StringSpec({
    "구분자는 comma 가 포함된다" {
        val comma = ","
        val delimiter = DelimiterEnum.find(comma)
        delimiter.value shouldBe comma
    }

    "구분자는 colon 가 포함된다" {
        val colon = ":"
        val delimiter = DelimiterEnum.find(colon)
        delimiter.value shouldBe colon
    }

    "구분자로 존재하지 않는 문자열을 넣으면 예외가 발생한다" {
        val hash = "#"
        shouldThrow<IllegalArgumentException> { DelimiterEnum.find(hash) }
    }
})
