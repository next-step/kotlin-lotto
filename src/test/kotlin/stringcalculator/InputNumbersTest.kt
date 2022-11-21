package stringcalculator

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

/**
 * @see InputNumbers
 */
class InputNumbersTest : ExpectSpec({

    context("객체 생성") {
        expect("커스텀 구분자가 있으면 해당 구분자로 구분한다.") {
            val input = "//;\n1;2;3"
            val inputNumbers = InputNumbers.from(input)

            inputNumbers.values.map { inputNumber ->
                inputNumber.value
            } shouldBe listOf(1, 2, 3)
        }

        expect("커스텀 구분자가 없으면 기본 구분자로 구분한다.") {
            val input = "1,2:3,4:5"
            val inputNumbers = InputNumbers.from(input)

            inputNumbers.values.map { inputNumber ->
                inputNumber.value
            } shouldBe listOf(1, 2, 3, 4, 5)
        }
    }
})
