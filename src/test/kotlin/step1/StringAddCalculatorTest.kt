package step1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : BehaviorSpec({

    val stringAddCalculator = StringAddCalculator()

    given("빈 문자열이나 Null을 입력할 경우") {
        listOf("", null).forEach { input ->
            `when`("StringAddCalculator.calculate(\"$input\")") {
                val result = stringAddCalculator.calculate(input)

                then("should return 0") {
                    result shouldBe 0
                }
            }
        }
    }

    given("숫자 하나를 문자열로 입력할 경우") {
        (0..100).asSequence()
            .forEach { singleNumberInput ->
                val inputText = singleNumberInput.toString()
                `when`("StringAddCalculator.calculate(\"$inputText)\"") {
                    val result = stringAddCalculator.calculate(inputText)

                    then("should return $singleNumberInput") {
                        result shouldBe singleNumberInput
                    }
                }
            }
    }

    xgiven("숫자 두개를 , 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
        val firstNumber = 0
        val secondNumber = 1
        val inputText = "$firstNumber${StringAddCalculator.DEFAULT_DELIMITER}$secondNumber"

        `when`("StringAddCalculator.calculate(\"$inputText\")") {
            val result = stringAddCalculator.calculate(inputText)

            then("should return $inputText") {
                result shouldBe firstNumber + secondNumber
            }
        }
    }
})
