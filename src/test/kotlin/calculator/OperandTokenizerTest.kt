package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class OperandTokenizerTest : FunSpec({
    context("Operand 토큰화") {
        context("문자열을 전달하면") {
            test("구분자를 기준으로 토큰화할 수 있다.") {
                // given
                val expression = Expression.from("1,2,3")
                // when
                val actual = OperandTokenizer.tokenize(expression = expression)
                // then
                actual.operands shouldContainExactly listOf(
                    Operand.from("1"),
                    Operand.from("2"),
                    Operand.from("3"),
                )
            }
        }
    }
})
