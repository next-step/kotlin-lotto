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
        InputDataSet.testValidNumberDataList().asSequence()
            .forEach { inputNumber ->
                val inputText = inputNumber.toString()
                `when`("StringAddCalculator.calculate(\"$inputText)\"") {
                    val result = stringAddCalculator.calculate(inputText)

                    then("should return $inputNumber") {
                        result shouldBe inputNumber
                    }
                }
            }
    }

    given("숫자 두개를 , 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
        InputDataSet.testValidNumberPairDataList().forEach { pair ->
            val firstNumber = pair.first
            val secondNumber = pair.second
            val inputText = "$firstNumber${StringAddCalculator.DEFAULT_DELIMITER}$secondNumber"

            `when`("StringAddCalculator.calculate(\"$inputText\")") {
                val result = StringAddCalculator().calculate(inputText)

                then("should return $inputText") {
                    result shouldBe firstNumber + secondNumber
                }
            }
        }
    }
})
