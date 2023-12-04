package camp.nextstep.edu.step.step2.domain.number

import camp.nextstep.edu.step.step2.domain.number.Number
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("로또 번호는")
class NumberTest : BehaviorSpec({

    Given("1~45 사이의 숫자가 주어지고") {
        val number = 1

        When("생성을 요청하면") {
            val lottoNumber = Number(number = number)

            Then("주어진 숫자가 생성된다") {
                lottoNumber shouldBe Number(number = 1)
            }
        }
    }

    Given("만약 1~45 사이가 아닐경우") {
        val number = 46

        When("생성을 요청하면") {
            val lottoNumber = shouldThrow<java.lang.IllegalArgumentException> {
                Number(number = number)
            }

            Then("예외가 발생한다") {
                lottoNumber.message shouldBe "로또 번호는 1~45 사이여야 합니다."
            }
        }
    }

})
