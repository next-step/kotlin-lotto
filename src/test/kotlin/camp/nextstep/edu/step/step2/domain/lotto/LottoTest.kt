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
                lotto shouldBe Lotto(
                    numbers = listOf(
                        Number(number = 1),
                        Number(number = 2),
                        Number(number = 3),
                        Number(number = 4),
                        Number(number = 5),
                        Number(number = 6)
                    )
                )
            }
        }
    }

    Given("로또의 번호들은") {

        When("새로운 번호 생성 요청이 들어오면") {
            val lotto = Lotto.generateAutoNumbers()

            Then("6개의 번호가 생성된다") {
                lotto.numbers.size shouldBe 6
            }
        }
    }

})
