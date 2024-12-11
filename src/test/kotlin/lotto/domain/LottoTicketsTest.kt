package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `로또 티켓은 구입금액은 1_000원 이상이여야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoTickets.purchase(900)
        }.also {
            it.message shouldBe "구입금액은 1000원 이상이여야 합니다"
        }
    }

    @Test
    fun `로또 티켓을 구입 금액에 맞게 발급한다`() {
        val amount = 5_000
        val lottoTickets = LottoTickets.purchase(amount)
        lottoTickets.tickets.size shouldBe 5
    }
}
