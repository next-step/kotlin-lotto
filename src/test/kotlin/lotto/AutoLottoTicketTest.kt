package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.AutoLottoTicket

internal class AutoLottoTicketTest : BehaviorSpec({
    Given("사용자가 ") {
        When("로또 티켓을 생성하면, ") {
            val lottoTicket = AutoLottoTicket()
            Then("로또 번호는 6개이다.") {
                lottoTicket.lottoNumbers.size shouldBe 6
            }

            Then("로또 번호는 1과 45 사이의 숫자로 이루어져 있다.") {
                lottoTicket.lottoNumbers.all { it.number in 1..45 } shouldBe true
            }
        }
    }
})
