package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.next

class LottoTicketMachineTest : BehaviorSpec({

    Given("로또 번호 발급기는") {
        And("무작위 번호로된 티켓을 1개 생성하고") {
            val tickets = LottoTicketMachine.generate()

            Then("생성된 티켓은 1개다") {
                tickets shouldHaveSize 1
            }

            val actual = tickets.first().numbers
            Then("생성된 번호는 6개이다") {
                actual shouldHaveSize LottoTicket.SIZE_OF_LOTTO_NUMBER
            }

            Then("생성된 번호는 모두 다른 번호이다") {
                actual.distinct() shouldHaveSize LottoTicket.SIZE_OF_LOTTO_NUMBER
            }

            Then("생성된 번호는 오름차순으로 정렬되어 있다") {
                actual.shouldBeSorted()
            }
        }

        And("무작위 번호로된 티켓을 n개 생성하고") {
            val numberOfTicket = Arb.int(1..10).next()
            val tickets = LottoTicketMachine.generate(numberOfTicket)

            Then("생성된 티켓의 개수는 요청 개수와 동일하다") {
                tickets shouldHaveSize numberOfTicket
            }

            tickets.forAll { (numbers) ->
                val actualName = numbers.joinToString()
                Then("생성된 번호는 6개이다 ($actualName)") {
                    numbers shouldHaveSize LottoTicket.SIZE_OF_LOTTO_NUMBER
                }

                Then("생성된 번호는 모두 다른 번호이다 ($actualName)") {
                    numbers.distinct() shouldHaveSize LottoTicket.SIZE_OF_LOTTO_NUMBER
                }

                Then("생성된 번호는 오름차순으로 정렬되어 있다 ($actualName)") {
                    numbers.shouldBeSorted()
                }
            }
        }
    }
})
