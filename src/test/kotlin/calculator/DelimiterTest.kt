package calculator

import calculator.domain.Delimiter
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DelimiterTest : StringSpec({
    "구분자는 comma 가 포함된다" {
        val comma = ","
        val delimiter = Delimiter.find(comma)
        delimiter.value shouldBe comma
    }
})
