package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicketIssuer.DEFAULT_LOTTO_PRICE
import lotto.domain.LottoTicketIssuer.INVALID_MIN_COST_LOTTO_PAID_MESSAGE
import lotto.domain.LottoTicketIssuer.INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE
import org.junit.jupiter.api.Test

class LottoTicketIssuerTest {
    @Test
    fun `로또 구입 비용이 1,000원 미만일 경우 에러가 발생한다` () {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_MIN_COST_LOTTO_PAID_MESSAGE) {
            LottoTicketIssuer.issueTickets(amountPaid = 500)
        }
    }

    @Test
    fun `로또 구입 비용이 1,000원 단위가 아닐 경우 에러가 발생한다` () {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE) {
            LottoTicketIssuer.issueTickets(amountPaid = 14500)
        }
    }

    @Test
    fun `로또 구입 비용에 대해 몇 장의 로또가 구입됐는지 확인활 수 있다` () {
        val purchasedLottoTickets = LottoTicketIssuer.issueTickets(amountPaid = 5000)
        purchasedLottoTickets.purchasedCount shouldBe 5000 / DEFAULT_LOTTO_PRICE
    }
}
