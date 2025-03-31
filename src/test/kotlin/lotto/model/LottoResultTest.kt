package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `should calculate matches`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val tickets = listOf(
            TicketModel(listOf(1, 2, 3, 4, 5, 7))
        )
        val lottoResult = LottoResult(winningNumbers, tickets)
        val result = lottoResult.calculateResult()
        assertThat(result[5]).isEqualTo(1)
    }

    @Test
    fun `should calculate total prize correctly`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val tickets = listOf(
            TicketModel(listOf(1, 2, 3, 4, 5, 6)),
            TicketModel(listOf(1, 2, 3, 4, 5, 7)),
            TicketModel(listOf(1, 2, 3, 4, 7, 8)),

        )
        val lottoResult = LottoResult(winningNumbers, tickets)
        assertThat(lottoResult.totalPrize()).isEqualTo(2_001_550_000)
    }
}