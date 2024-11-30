package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
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
}
