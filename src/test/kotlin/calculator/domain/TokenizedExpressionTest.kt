package calculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class TokenizedExpressionTest : StringSpec({
    "구분자(특정 문자)를 사용해 문자열을 분리할 수 있다." {
        forAll(
            row("1,2:3", listOf("1", "2", "3")),
            row("//;\n1;2;3", listOf("1", "2", "3")),
        ) { inputData, expected ->
            val expression = TokenizedExpression.generate(inputData)
            expression shouldBe expected
        }
    }
})
