package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class ExpressionTest : FunSpec({
    context("Expression 생성") {
        context("올바른 문자열을 전달하면") {
            test("Expression 을 생성할 수 있다.") {
                // given
                val expression = "1:2"
                // when
                val actual = Expression.from(expression = expression)
                // then
                actual.value shouldBe "1:2"
            }
        }

        context("빈 문자열을 전달하면") {
            test("예외가 발생한다.") {
                // given
                val expression = ""
                // when
                val exception = assertThrows<IllegalArgumentException> { Expression.from(expression = expression) }
                // then
                exception.message shouldBe "빈 문자열 또는 null 을 입력할 수 없습니다."
            }
        }

        context("null 을 전달하면") {
            test("예외가 발생한다.") {
                // given
                val expression = null
                // when
                val exception = assertThrows<IllegalArgumentException> { Expression.from(expression = expression) }
                // then
                exception.message shouldBe "빈 문자열 또는 null 을 입력할 수 없습니다."
            }
        }
    }
})
