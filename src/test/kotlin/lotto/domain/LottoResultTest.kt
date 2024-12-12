package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `결과를 확인한다`() {
        val tickets = listOf(LottoTicket(1, 2, 3, 4, 5, 6))
        val winTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val result = LottoResult(tickets, winTicket, 1)
        result.first shouldBe 1
    }
}
