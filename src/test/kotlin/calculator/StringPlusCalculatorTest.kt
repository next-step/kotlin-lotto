package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class StringPlusCalculatorTest : FunSpec({
    context("문자열 덧셈 계산") {
        context("올바른 문자열을 전달하면") {
            test("문자열의 합을 구할 수 있다.") {
                // given
                val expression = "1,2"
                val sut = StringPlusCalculator()
                // when
                val actual = sut.calculate(expression = expression)
                // then
                actual shouldBe 3
            }
        }

        context("빈 문자열을 전달하면") {
            test("예외가 발생한다.") {
                // given
                val expression = ""
                val sut = StringPlusCalculator()
                // when
                val exception = assertThrows<IllegalArgumentException> { sut.calculate(expression = expression) }
                // then
                exception.message shouldBe "빈 문자열을 입력할 수 없습니다."
            }
        }
    }
})
