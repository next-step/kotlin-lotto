package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    context("문자열 계산기를 사용하여 계산을 실행할 때") {
        test("빈 문자열을 입력하면 0을 반환한다.") {
            // given
            val sut = StringCalculator.of(text = "")

            // when
            val result = sut.execute()

            // then
            result shouldBe 0
        }

        test(""""//;\n"과 같이 커스텀 구분자만 입력하고 계산할 문자열이 비어있으면 0을 반환한다.""") {
            // given
            val sut = StringCalculator.of(text = "//;\n")

            // when
            val result = sut.execute()

            // then
            result shouldBe 0
        }

        test("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.") {
            // given
            val sut = StringCalculator.of(text = "12")

            // when
            val result = sut.execute()

            // then
            result shouldBe 12
        }

        test("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
            // given
            val sut = StringCalculator.of(text = "1,2")

            // when
            val result = sut.execute()

            // then
            result shouldBe 3
        }

        test("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.") {
            // give
            val sut = StringCalculator.of(text = "1,2:3")

            // when
            val result = sut.execute()

            // then
            result shouldBe 6
        }

        test("""//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.""") {
            // given
            val sut = StringCalculator.of(text = "//;\n1;2;3")

            // when
            val result = sut.execute()

            // then
            result shouldBe 6
        }

        test("문자열 계산기에 음수를 전달하는 경우 예외.") {
            // given
            val sut = StringCalculator.of(text = "1,-1")

            // when then
            shouldThrow<IllegalArgumentException> {
                sut.execute()
            }
        }

        test("커스텀 구분자에는 숫자를 포함할 수 없다.") {
            // when then
            shouldThrow<IllegalArgumentException> {
                StringCalculator.of(text = "//1\n11;2")
            }
        }
    }
})
