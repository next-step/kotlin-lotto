package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {
    @ParameterizedTest
    @CsvSource(
        "{1,2,3,4,5,6}, 1",
    )
    fun `1등 당첨되었는지 확인한다`(numbers: List<Int>, count: Int) {
        val tickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val winTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val result = LottoResult(tickets, winTicket, 1)
        result.first shouldBe 1
    }

    @Test
    fun `2등 당첨되었는지 확인한다`() {
        val tickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val winTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 7))
        val result = LottoResult(tickets, winTicket, 1)
        result.second shouldBe 1
    }

    @Test
    fun `3등 당첨되었는지 확인한다`() {
        val tickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val winTicket = LottoTicket(listOf(1, 2, 3, 4, 7, 8))
        val result = LottoResult(tickets, winTicket, 1)
        result.third shouldBe 1
    }

    @Test
    fun `4등 당첨되었는지 확인한다`() {
        val tickets = listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        val winTicket = LottoTicket(listOf(1, 2, 3, 7, 8, 9))
        val result = LottoResult(tickets, winTicket, 1)
        result.fourth shouldBe 1
    }
}
