package calculator

import calculator.domain.OperationParser
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class OperationParserTest : BehaviorSpec({

    Given("OperationParser") {
        val operationParser = OperationParser

        When("쉼표와 콜론이 혼합되어 있으면") {
            val inputs = listOf(
                "1,2,3" to listOf("1", "2", "3"),
                "1,2:3" to listOf("1", "2", "3"),
                "1:2:3" to listOf("1", "2", "3")
            )

            Then("각 숫자의 리스트를 가진 OperationTokens를 반환한다.") {
                inputs.forAll { input ->
                    val actual = operationParser.parse(input.first)
                    actual.tokenList shouldBe input.second
                }
            }
        }

        When("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자가 입력되면") {
            val customDelimiters = listOf("$", "#", "^")
            val inputs = customDelimiters.map {
                "//$it\n1${it}2${it}3" to listOf("1", "2", "3")
            }

            Then("커스텀 구분자까지 포함하여 파싱된 OperationTokens를 반환한다.") {
                inputs.forAll { input ->
                    val actual = operationParser.parse(input.first)
                    actual.tokenList shouldBe input.second
                }
            }
        }
    }
})
