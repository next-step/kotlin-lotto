package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.store.LottoTickets
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName

@DisplayName("로또 티켓은")
class LottoTicketsTest : BehaviorSpec({

    Given("티켓 수량이 주어지면") {
        val ticketAmount = 1

        When("생성 시") {
            val lottoTickets = LottoTickets.of(ticketAmount)

            Then("주어진 수량만큼의 로또 티켓이 생성된다") {
                assertEquals(lottoTickets.getLottoTicketAmount(), 1)
            }
        }
    }

    Given("로또 티켓이 생성되고") {
        val lottoTickets = LottoTickets.of(lottoTicketAmount = 5)

        When("로또 번호 생성시") {
            val lottoNumbers = lottoTickets.createNumbersByLottoTicketAmount()

            Then("주어진 티켓 수만큼 로또 번호가 생성된다") {
                println(lottoNumbers)
                assertEquals(lottoNumbers.size, 5)
            }
        }
    }

    Given("만약 구매금액이 0원일 경우") {
        val buyAmount = 0

        When("생성시") {
            val lottoTickets = shouldThrow<IllegalArgumentException> {
                LottoTickets.of(lottoTicketAmount = buyAmount)
            }

            Then("예외가 발생한다") {
                lottoTickets.message shouldBe "로또 티켓은 1개 이상이어야 합니다."
            }
        }
    }

    Given("로또 티켓이 주어지고") {
        val ticketAmount = 1
        val lottoTickets = LottoTickets.of(ticketAmount)

        When("숫자 생성을 요청하면") {
            val lottoNumbers = lottoTickets.createNumbersByLottoTicketAmount()

            Then("구매 수량만큼 로또번호가 생성된다.") {
                lottoNumbers.size shouldBe 1
            }
        }
    }

})
