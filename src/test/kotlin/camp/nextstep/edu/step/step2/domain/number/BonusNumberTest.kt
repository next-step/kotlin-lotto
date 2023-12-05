package camp.nextstep.edu.step.step2.domain.number

import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

@DisplayName("보너스 번호는")
class BonusNumberTest : BehaviorSpec({

    Given("번호가 주어지고") {
        val number = 1

        When("보너스 번호를 생성하면") {
            val bonusNumber = BonusNumber(number = Number(number = number))

            Then("보너스 번호가 생성된다") {
                bonusNumber.number shouldBe Number(number = 1)
            }
        }
    }

})
