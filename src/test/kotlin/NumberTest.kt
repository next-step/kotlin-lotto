import calculator.Number
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll

class NumberTest : BehaviorSpec({

    val negativeNum = "-1"
    Given("음수가") {
        When("전달되면") {
            Then("RuntimeException 예외가 발생한다.") {
                shouldThrow<RuntimeException> {
                    Number.of(negativeNum)
                }
            }
        }
    }

    val notNum = listOf("*", "!", "a")
    Given("숫자 이외의 값이") {
        When("전달되면") {
            Then("RuntimeException 예외가 발생한다.") {
                notNum.forAll {
                    shouldThrow<RuntimeException> {
                        Number.of(it)
                    }
                }
            }
        }
    }
})
