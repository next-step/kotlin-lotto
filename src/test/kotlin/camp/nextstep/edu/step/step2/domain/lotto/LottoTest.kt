package camp.nextstep.edu.step.step2.domain.lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("로또 번호들은")
class LottoTest : BehaviorSpec({

    Given("로또 번호들이 주어지고") {
        val requestNumbers = listOf(
            Number(number = 1),
            Number(number = 2),
            Number(number = 3),
            Number(number = 4),
            Number(number = 5),
            Number(number = 6)
        )

        When("생성을 요청하면") {
            val lotto = Lotto(numbers = requestNumbers)

            Then("주어진 로또 번호들이 생성된다") {
                lotto.numbers shouldBe listOf(
                    Number(number = 1),
                    Number(number = 2),
                    Number(number = 3),
                    Number(number = 4),
                    Number(number = 5),
                    Number(number = 6)
                )
            }
        }
    }

})
