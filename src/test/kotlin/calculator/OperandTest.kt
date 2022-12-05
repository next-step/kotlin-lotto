package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class OperandTest : FunSpec({
    context("Operand 생성") {
        context("문자열로") {
            context("양수를 전달하면") {
                test("Operand 를 생성할 수 있다.") {
                    // given
                    val expression = "3"
                    // when
                    val actual = Operand.from(expression = expression)
                    // then
                    actual.value shouldBe 3
                }
            }

            context("음수를 전달하면") {
                test("예외가 발생한다.") {
                    // given
                    val expression = "-3"
                    // when
                    val exception = assertThrows<IllegalArgumentException> { Operand.from(expression = expression) }
                    // then
                    exception.message shouldBe "음수 또는 숫자가 아닌 값을 입력할 수 없습니다."
                }
            }
            context("숫자가 아닌 값을 전달하면") {
                test("예외가 발생한다.") {
                    // given
                    val expression = "동구"
                    // when
                    val exception = assertThrows<IllegalArgumentException> { Operand.from(expression = expression) }
                    // then
                    exception.message shouldBe "음수 또는 숫자가 아닌 값을 입력할 수 없습니다."
                }
            }
        }
    }
})
