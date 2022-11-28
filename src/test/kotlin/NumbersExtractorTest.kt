import calculator.Number
import calculator.NumbersExtractor
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class NumbersExtractorTest : BehaviorSpec({

    val textForZero = listOf(null, "", " ")
    Given("빈 문자열 또는 null을 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("숫자 0이 담긴 리스트가 반환된다.") {
                textForZero.map {
                    NumbersExtractor.run(it)
                }.forAll {
                    it shouldBe listOf(Number(0))
                }
            }
        }
    }

    val textWithOneNum = "1"
    Given("숫자 하나를 문자열로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자가 담긴 리스트가 반환한다.") {
                NumbersExtractor.run(textWithOneNum) shouldBe listOf(Number(1))
            }
        }
    }

    val textWithComma = "1,2"
    Given("여러 숫자를 쉼표(,) 구분자로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                NumbersExtractor.run(textWithComma) shouldBe listOf(Number(1), Number(2))
            }
        }
    }

    val textWithDefaultDelimiter = "1,2:3"
    Given("여러 숫자를 쉼표(,) 이외에 콜론(:)도 구분자로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                NumbersExtractor.run(textWithDefaultDelimiter) shouldBe listOf(
                    Number(1),
                    Number(2),
                    Number(3)
                )
            }
        }
    }

    val textWithCustomDelimiter = "//;\n1;2;3"
    Given("여러 숫자를 커스텀 구분자로 입력할 경우") {
        When("피연산자를 추출하면") {
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                NumbersExtractor.run(textWithCustomDelimiter) shouldBe listOf(
                    Number(1),
                    Number(2),
                    Number(3)
                )
            }
        }
    }
})
