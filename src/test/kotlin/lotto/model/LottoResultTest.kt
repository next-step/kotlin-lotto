package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `should calculate matches`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val tickets = listOf(
            TicketModel(listOf(1, 2, 3, 4, 5, 6))
        )
        val lottoResult = LottoResult(winningNumbers, tickets)
        val result = lottoResult.calculateResult()
        assertThat(result[6]).isEqualTo(1)
    }
}