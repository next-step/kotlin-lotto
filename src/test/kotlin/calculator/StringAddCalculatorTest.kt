package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.lang.RuntimeException

class StringAddCalculatorTest : FunSpec({
    test("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.") {
        listOf("", null)
            .forAll { expression ->
                // given
                val calculator = StringAddCalculator()
                // when
                val actual = calculator.add(expression)
                // then
                actual shouldBe 0
            }
    }

    test("\t, \n 와 같은 whitespace 를 입력할 경우 0을 반환해야 한다.") {
        listOf("\t", "\n")
            .forAll { expression ->
                // given
                val calculator = StringAddCalculator()
                // when
                val actual = calculator.add(expression)
                // then
                actual shouldBe 0
            }
    }

    test("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.") {
        // given
        val expression = "3"
        val expected = 3
        val calculator = StringAddCalculator()
        // when
        val actual = calculator.add(expression)
        // then
        actual shouldBe expected
    }

    test("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
        listOf("1,2,3", "3,3", "2,2,2")
            .forAll { expression ->
                // given
                val expected = 6
                val calculator = StringAddCalculator()
                // when
                val actual = calculator.add(expression)
                // then
                actual shouldBe expected
            }
    }

    test("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.") {
        // given
        val expression = "3,4:5"
        val expected = 12
        val calculator = StringAddCalculator()

        // when
        val actual = calculator.add(expression)

        // then
        actual shouldBe expected
    }

    test("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.") {
        // given
        val expression = "//;\n1;2;3"
        val expected = 6
        val calculator = StringAddCalculator()

        // when
        val actual = calculator.add(expression)

        // then
        actual shouldBe expected
    }


    test("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.") {
        listOf("-1,2,3", "-3", "-3:2")
            .forAll { expression ->
                // given
                val expected = 6
                val calculator = StringAddCalculator()
                // when, then
                shouldThrow<RuntimeException> {
                    calculator.add(expression)
                }
            }
    }
})
