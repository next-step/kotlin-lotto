package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.collections.shouldHaveSize

class LottoTicketMachineTest : BehaviorSpec({

    Given("로또 번호 발급기는 ") {
        And("무작위 번호를 생성하고") {
            val numbers = LottoTicketMachine.generate()

            Then("생성된 번호는 6개이다") {
                numbers.shouldHaveSize(LottoTicketMachine.SIZE_OF_LOTTO_NUMBER)
            }

            Then("생성된 번호는 모두 다른 번호이다") {
                numbers.distinct().shouldHaveSize(LottoTicketMachine.SIZE_OF_LOTTO_NUMBER)
            }

            Then("생성된 번호는 오름차순으로 정렬되어 있다") {
                numbers.shouldBeSorted()
            }
        }
    }
})
