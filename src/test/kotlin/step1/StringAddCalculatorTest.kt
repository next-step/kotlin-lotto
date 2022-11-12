package step1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : BehaviorSpec({

    val stringAddCalculator = StringAddCalculator()

    given("빈 문자열이나 Null을 입력할 경우") {
        listOf("", null).forEach { input ->
            `when`("빈 문자열이나 Null을 입력할 경우, \"$input\"") {
                val result = stringAddCalculator.calculate(input)

                then("StringAddCalculator.calculate(\"$input\")\" should return 0") {
                    result shouldBe 0
                }
            }
        }
    }

    given("숫자 하나를 문자열로 입력할 경우") {
        InputDataSet.testValidNumberDataList()
            .asSequence()
            .forEach { inputNumber ->
                val inputText = inputNumber.toString()
                `when`("숫자 하나를 문자열로 입력할 경우, \"$inputText\"") {
                    val result = stringAddCalculator.calculate(inputText)

                    then("StringAddCalculator.calculate(\"$inputText\") should return $inputNumber") {
                        result shouldBe inputNumber
                    }
                }
            }
    }

    given("숫자 두개를 , 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
        InputDataSet.testValidNumberPairDataList()
            .asSequence()
            .shuffled()
            .take(100)
            .forEach { pair ->
                val firstNumber = pair.first
                val secondNumber = pair.second
                val inputText = "$firstNumber,$secondNumber"

                `when`("숫자 두개를 , 구분자로 입력할 경우, \"$inputText\"") {
                    val result = stringAddCalculator.calculate(inputText)

                    then("stringAddCalculator.calculate(\"$inputText\") should return $inputText") {
                        result shouldBe firstNumber + secondNumber
                    }
                }
            }
    }

    given("구분자를 `,` 이외에 `:`을 사용할 수 있다.") {
        fun randomDelimiter() = listOf(",", ":").random()

        InputDataSet.testValidNumberTuple3DataList()
            .asSequence()
            .shuffled()
            .take(100)
            .forEach { tuple ->
                val inputText = "${tuple.a}${randomDelimiter()}${tuple.b}${randomDelimiter()}${tuple.c}"
                val expected = tuple.a + tuple.b + tuple.c

                `when`("구분자를 `,` 이외에 `:` 를 사용할 경우, \"$inputText\"") {
                    val result = stringAddCalculator.calculate(inputText)

                    then("stringAddCalculator.calculate(\"$inputText\") should return $expected") {
                        result shouldBe expected
                    }
                }
            }
    }

    given("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.") {
        fun randomDelimiter() = listOf(",", ":", "-", "~", "/", "%", "+", "-", "|", "?", "*").random()

        InputDataSet.testValidNumberTuple3DataList()
            .shuffled()
            .take(100)
            .forEach { tuple ->
                val givenCustomDelimiter = randomDelimiter()
                val inputText = "//$givenCustomDelimiter\n${tuple.a}$givenCustomDelimiter${tuple.b}$givenCustomDelimiter${tuple.c}"
                val expected = tuple.a + tuple.b + tuple.c

                `when`("커스텀 구분자를 지정한 경우, \"$inputText\"") {
                    val result = stringAddCalculator.calculate(inputText)

                    then("stringAddCalculator.calculate(\"$inputText\") should return $expected") {
                        result shouldBe expected
                    }
                }
            }
    }
})
