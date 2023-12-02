package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.store.LottoTicketAmount
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
            val lottoTicketAmount = LottoTicketAmount(lottoTicketAmount = ticketAmount)

            Then("주어진 수량만큼의 로또 티켓이 생성된다") {
                assertEquals(lottoTicketAmount.lottoTicketAmount, 1)
            }
        }
    }

    Given("만약 구매금액이 0원일 경우") {
        val buyAmount = 0

        When("생성시") {
            val lottoTicketAmount = shouldThrow<IllegalArgumentException> {
                LottoTicketAmount(lottoTicketAmount = buyAmount)
            }

            Then("예외가 발생한다") {
                lottoTicketAmount.message shouldBe "로또 티켓은 1개 이상이어야 합니다."
            }
        }
    }

})
