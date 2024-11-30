package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicketIssuer.DEFAULT_LOTTO_PRICE
import lotto.domain.LottoTicketIssuer.INVALID_MIN_COST_LOTTO_PAID_MESSAGE
import lotto.domain.LottoTicketIssuer.INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTicketIssuerTest {
    @ParameterizedTest
    @ValueSource(ints = [500, 999])
    fun `로또 구입 비용이 1,000원 미만일 경우 에러가 발생한다` (amountPaid: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_MIN_COST_LOTTO_PAID_MESSAGE) {
            LottoTicketIssuer.issueTickets(amountPaid = amountPaid)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1500, 22200, 10500, 2100005])
    fun `로또 구입 비용이 1,000원 단위가 아닐 경우 에러가 발생한다` (amountPaid: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE) {
            LottoTicketIssuer.issueTickets(amountPaid = amountPaid)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [5000, 1000, 23000, 3000])
    fun `로또 구입 비용에 대해 몇 장의 로또가 구입됐는지 확인활 수 있다` (amountPaid: Int) {
        val purchasedLottoTickets = LottoTicketIssuer.issueTickets(amountPaid = amountPaid)
        val purchasedCount = amountPaid / DEFAULT_LOTTO_PRICE
        purchasedLottoTickets.purchasedCount shouldBe purchasedCount
        purchasedLottoTickets.purchasedLottoTickets.size shouldBe purchasedCount
    }
}
