package camp.nextstep.edu.step.step2.domain.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("로또 번호들은")
class NumbersTest : BehaviorSpec({

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
            val numbers = Numbers.ofNumbers(numbers = requestNumbers)

            Then("주어진 로또 번호들이 생성된다") {
                numbers shouldBe Numbers.ofNumbers(
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


    Given("만약 중복인 숫자가 포함되어 있을 경우") {
        val requestNumbers = listOf(
            Number(number = 1),
            Number(number = 2),
            Number(number = 3),
            Number(number = 4),
            Number(number = 5),
            Number(number = 5)
        )

        When("생성을 요청하면") {
            val numbers = shouldThrow<IllegalArgumentException> {
                Numbers.ofNumbers(numbers = requestNumbers)
            }

            Then("예외가 발생한다") {
                numbers.message shouldBe "로또 번호는 중복될 수 없습니다."
            }
        }
    }

    Given("로또의 번호들은") {

        When("새로운 번호 생성 요청이 들어오면") {
            val numbers = Numbers.createNumbers()

            Then("6개의 번호가 생성된다") {
                numbers.size shouldBe 6
            }
        }
    }

})
