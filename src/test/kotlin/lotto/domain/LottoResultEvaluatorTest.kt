package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultEvaluatorTest {

    @Test
    @DisplayName("주어진 티켓 목록과 당첨 티켓으로 매치 결과가 올바르게 생성된다")
    fun `주어진 티켓 목록과 당첨 티켓으로 매치 결과가 올바르게 생성된다`() {
        val winningTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val tickets = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket(listOf(1, 2, 3, 4, 5, 7)),
        )
        val evaluator = LottoResultEvaluator(winningTicket, 7)
        val result = evaluator.evaluate(tickets)

        assertEquals(1, result.getMatchCount(6))
        assertEquals(1, result.getMatchCount(5))
    }
}
