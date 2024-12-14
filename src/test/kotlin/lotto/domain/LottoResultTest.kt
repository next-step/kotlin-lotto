package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `1등을 확인한다`() {
        val tickets = listOf(LottoTicket(1, 2, 3, 4, 5, 6))
        val winTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val result = LottoResult(tickets, winTicket, 1)
        result.first shouldBe 1
    }

    @Test
    fun `2등을 확인한다`() {
        val tickets = listOf(LottoTicket(1, 2, 3, 4, 5, 6))
        val winTicket = LottoTicket(1, 2, 3, 4, 5, 7)
        val result = LottoResult(tickets, winTicket, 1)
        result.second shouldBe 1
    }

    @Test
    fun `3등을 확인한다`() {
        val tickets = listOf(LottoTicket(1, 2, 3, 4, 5, 6))
        val winTicket = LottoTicket(1, 2, 3, 4, 7, 8)
        val result = LottoResult(tickets, winTicket, 1)
        result.third shouldBe 1
    }

    @Test
    fun `4등을 확인한다`() {
        val tickets = listOf(LottoTicket(1, 2, 3, 4, 5, 6))
        val winTicket = LottoTicket(1, 2, 3, 7, 8, 9)
        val result = LottoResult(tickets, winTicket, 1)
        result.fourth shouldBe 1
    }
}
