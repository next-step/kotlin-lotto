import calculator.OperandExtractor
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class OperandExtractorTest : BehaviorSpec({

    val textForZero = listOf(null, "", " ")
    Given("빈 문자열 또는 null을 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("0이 담긴 리스트가 반환된다.") {
                textForZero.map {
                    OperandExtractor.extractOperand(it)
                }.forAll {
                    it shouldBe listOf(0)
                }
            }
        }
    }

    val textWithOneNumbers = listOf(
        "1" to listOf(1),
        "3" to listOf(3),
        "7" to listOf(7)
    )
    Given("숫자 하나를 문자열로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자가 담긴 리스트가 반환한다.") {
                textWithOneNumbers.forAll { (text, result) ->
                    OperandExtractor.extractOperand(text) shouldBe result
                }
            }
        }
    }

    val textWithOneDelimiters = listOf(
        "1,2" to listOf(1, 2),
        "3,7,10" to listOf(3, 7, 10),
        "100,200,300,400,500" to listOf(100, 200, 300, 400, 500)
    )
    Given("여러 숫자를 쉼표(,) 구분자로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                textWithOneDelimiters.forAll { (text, result) ->
                    OperandExtractor.extractOperand(text) shouldBe result
                }
            }
        }
    }

    val textWithTwoDelimiters = listOf(
        "1,2:3" to listOf(1, 2, 3),
        "3:7:10" to listOf(3, 7, 10),
        "100:200,300:400,500" to listOf(100, 200, 300, 400, 500)
    )
    Given("여러 숫자를 쉼표(,) 이외에 콜론(:)도 구분자로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                textWithTwoDelimiters.forAll { (text, result) ->
                    OperandExtractor.extractOperand(text) shouldBe result
                }
            }
        }
    }

    val textWithCustomDelimiters = listOf(
        "//;\n1;2;3" to listOf(1, 2, 3),
        "//@\n3@7@10" to listOf(3, 7, 10),
        "//&\n100&200&300&400&500" to listOf(100, 200, 300, 400, 500)
    )
    Given("여러 숫자를 커스텀 구분자로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                textWithCustomDelimiters.forAll { (text, result) ->
                    OperandExtractor.extractOperand(text) shouldBe result
                }
            }
        }
    }
})
