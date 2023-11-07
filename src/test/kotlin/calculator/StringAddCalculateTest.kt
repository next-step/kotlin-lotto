package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringAddCalculateTest : FunSpec({

    val calculator = StringAddCalculator(
        NegativeNumberValidation()
    )

    context("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.") {
        withData(
            "" to 0,
            null to 0
        ) { (input, output) ->
            calculator.add(input) shouldBe output
        }
    }

    context("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.") {
        withData(
            "1" to 1,
            "2" to 2
        ) { (input, output) ->
            calculator.add(input) shouldBe output
        }
    }

    context("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
        withData(
            "1,2" to 3,
            "1,2,3,4" to 10
        ) { (input, output) ->
            calculator.add(input) shouldBe output
        }
    }

    context("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.") {
        withData(
            "1,2:3" to 6,
            "3:6,7" to 16
        ) { (input, output) ->
            calculator.add(input) shouldBe output
        }
    }

    context("문자 사이에 커스텀 구분자를 지정할 수 있다.") {
        withData(
            "//@\n1@2@3" to 6,
            "//!\n3!6,7" to 16
        ) { (input, output) ->
            calculator.add(input) shouldBe output
        }
    }

    context("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.") {
        shouldThrow<RuntimeException> {
            calculator.add("-1")
        }
        shouldThrow<RuntimeException> {
            calculator.add("-1:2")
        }
    }
})
