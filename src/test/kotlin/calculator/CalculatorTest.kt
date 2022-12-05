package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

internal class CalculatorTest : FunSpec({
    context("피연산자가 양수로만 구성될 경우 덧셈을 할 수 있다.") {
        withData(
            "1,2,3" to 6,
            "10,11,9" to 30,
            "0" to 0
        ) { (data, result) ->
            Calculator().execute(data) shouldBe result
        }
    }

    context("피연산자가 음수가 포함될 경우 덧셈을 할 수 없다.") {
        withData(
            "-1,2,3",
            "-10,11,9",
            "-99",
        ) { data ->
            shouldThrow<IllegalArgumentException> {
                Calculator().execute(data)
            }
        }
    }
})
