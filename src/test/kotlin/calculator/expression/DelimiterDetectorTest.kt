package calculator.expression

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class DelimiterDetectorTest : BehaviorSpec({

    Given("입력 문자열에 커스텀 구분자가 포함되어 있지 않은 경우") {
        val input = "1,2:3"
        When("DelimiterDetector를 생성했을 때") {
            val delimiterDetector = DelimiterDetector.from(input)
            Then("기본 구분자를 사용한다.") {
                delimiterDetector.delimiter shouldBe "[,:]"
            }
            And("입력 문자열이 그대로 반환된다.") {
                delimiterDetector.stringInput shouldBe "1,2:3"
            }
        }
    }
    Given("입력 문자열에 커스텀 구분자가 포함된 경우") {
        val input = "//;\n1;2;3"
        When("DelimiterDetector를 생성할 때") {
            val delimiterDetector = DelimiterDetector.from(input)
            Then("커스텀 구분자를 사용한다.") {
                delimiterDetector.delimiter shouldBe Regex.escape(";")
            }
            And("커스텀 구분자가 제거된 입력 문자열이 반환된다.") {
                delimiterDetector.stringInput shouldBe "1;2;3"
            }
        }
    }
    Given("입력 문자열이 null 인 경우") {
        val input: String? = null
        When("DelimiterDetector를 생성할 때") {
            val delimiterDetector = DelimiterDetector.from(input)
            Then("기본 구분자를 사용한다.") {
                delimiterDetector.delimiter shouldBe "[,:]"
            }
            And("0이 반환된다.") {
                delimiterDetector.stringInput shouldBe "0"
            }
        }
    }
    Given("입력 문자열이 빈 문자열인 경우") {
        val input = ""
        When("DelimiterDetector를 생성할 때") {
            val delimiterDetector = DelimiterDetector.from(input)
            Then("기본 구분자를 사용한다.") {
                delimiterDetector.delimiter shouldBe "[,:]"
            }
            And("0이 반환된다.") {
                delimiterDetector.stringInput shouldBe "0"
            }
        }
    }
})
