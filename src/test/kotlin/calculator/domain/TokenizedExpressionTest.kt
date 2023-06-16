package calculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class TokenizedExpressionTest : StringSpec({
    "구분자(특정 문자)를 사용해 문자열을 분리할 수 있다." {
        forAll(
            row(Separator("ㅋ"), "1ㅋ2:3", listOf("1", "2", "3")),
            row(Separator("&"), "1:2&3", listOf("1", "2", "3")),
            row(Separator("%"), "1:2%3", listOf("1", "2", "3")),
            row(Separator("s"), "1s2,3", listOf("1", "2", "3")),
        ) { separator, inputData, expected ->
            val separators = Separators()
            separators.add(separator)
            val expression = TokenizedExpression.generate(inputData, separators)
            expression shouldBe expected
        }
    }
})
