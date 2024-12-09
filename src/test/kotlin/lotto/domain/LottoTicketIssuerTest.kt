package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicketIssuer.INVALID_MIN_COST_LOTTO_PAID_MESSAGE
import lotto.domain.LottoTicketIssuer.INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTicketIssuerTest {
    @ParameterizedTest
    @ValueSource(ints = [500, 999])
    fun `로또 구입 비용이 1,000원 미만일 경우 에러가 발생한다`(amountPaid: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_MIN_COST_LOTTO_PAID_MESSAGE) {
            LottoTicketIssuer.issueTickets(amountPaid = amountPaid, generateLottoNumbers = { setOf(1, 2, 3, 4, 5, 6) })
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1500, 22200, 10500, 2100005])
    fun `로또 구입 비용이 1,000원 단위가 아닐 경우 에러가 발생한다`(amountPaid: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE) {
            LottoTicketIssuer.issueTickets(amountPaid = amountPaid, generateLottoNumbers = { setOf(1, 2, 3, 4, 5, 6) })
        }
    }

    @ParameterizedTest
    @CsvSource("5000, 5", "1000, 1")
    fun `로또 구입 비용에 대해 몇 장의 로또가 구입됐는지 확인활 수 있다`(
        amountPaid: Int,
        expectedTicketCount: Int,
    ) {
        val purchasedLottoTickets =
            LottoTicketIssuer.issueTickets(amountPaid = amountPaid, generateLottoNumbers = { setOf(1, 2, 3, 4, 5, 6) })
        purchasedLottoTickets.purchasedCount shouldBe expectedTicketCount
        purchasedLottoTickets.purchasedLottoTickets.size shouldBe expectedTicketCount
    }
}
