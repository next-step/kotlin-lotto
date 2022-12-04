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
                val sut = StringPlusCalculator()
                // when & then
                listOf(
                    Pair("1,2", 3), Pair("1:2", 3), Pair("1,2:3", 6),
                    Pair("1,5,9", 15), Pair("1:3:7", 11), Pair("1,5:7,8", 21)
                ).forEach { (expression, expected) ->
                    val actual = sut.calculate(input = expression)
                    actual shouldBe expected
                }
            }

            context("커스텀 구분자를 포함하면") {
                test("커스텀 구분자를 기준으로 합을 구할 수 있다.") {
                    // given
                    val sut = StringPlusCalculator()
                    listOf(
                        Pair("//;\n1;2", 3), Pair("//.\n1.2", 3), Pair("//!\n1!2!3", 6),
                        Pair("//@\n1@5@9", 15), Pair("//h\n1h3h7", 11), Pair("//,\n1,5,7,8", 21)
                    ).forEach { (expression, expected) ->
                        val actual = sut.calculate(input = expression)
                        actual shouldBe expected
                    }
                }
            }
        }

        context("빈 문자열을 전달하면") {
            test("예외가 발생한다.") {
                // given
                val expression = ""
                val sut = StringPlusCalculator()
                // when
                val exception = assertThrows<IllegalArgumentException> { sut.calculate(input = expression) }
                // then
                exception.message shouldBe "빈 문자열 또는 null 을 입력할 수 없습니다."
            }
        }

        context("null 을 전달하면") {
            test("예외가 발생한다.") {
                // given & when
                val sut = StringPlusCalculator()
                val exception = assertThrows<IllegalArgumentException> { sut.calculate(null) }
                // then
                exception.message shouldBe "빈 문자열 또는 null 을 입력할 수 없습니다."
            }
        }

        context("음수를 전달하면") {
            test("예외가 발생한다.") {
                // given
                val expression = "-3"
                val sut = StringPlusCalculator()
                // when
                val exception = assertThrows<IllegalArgumentException> { sut.calculate(input = expression) }
                // then
                exception.message shouldBe "음수 또는 숫자가 아닌 값을 입력할 수 없습니다."
            }
        }

        context("숫자가 아닌 값을 전달하면") {
            test("예외가 발생한다.") {
                // given
                val expression = "동구쓰"
                val sut = StringPlusCalculator()
                // when
                val exception = assertThrows<IllegalArgumentException> { sut.calculate(input = expression) }
                // then
                exception.message shouldBe "음수 또는 숫자가 아닌 값을 입력할 수 없습니다."
            }
        }
    }
})
