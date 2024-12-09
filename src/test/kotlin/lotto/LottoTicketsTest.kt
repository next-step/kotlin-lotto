package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketsTest {
    @Test
    fun `로또 티켓은 한장 이상 구입 해야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoTickets(listOf())
        }.also {
            it.message shouldBe "로또 티켓은 한장 이상 구입해야 합니다"
        }
    }

    @Test
    fun `로또 티켓을 구입 금액에 맞게 발급한다`() {
        val amount = 5_000
        val lottoTickets = LottoTickets.purchase(amount)
        lottoTickets.tickets.size shouldBe 5
    }
}
