package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultEvaluatorTest {

    @Test
    @DisplayName("6개 숫자가 모두 일치하는 경우를 올바르게 처리한다")
    fun `handles perfect match correctly`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusBall = 7
        val winningTicket = LottoTicket.from(winningNumbers.toList())
        val evaluator = LottoResultEvaluator(winningTicket, bonusBall)

        val userTicket = LottoTicket.from(winningNumbers.toList())
        val result = evaluator.evaluate(listOf(userTicket))

        assertEquals(1, result.getMatchCount(6))
    }

    @Test
    @DisplayName("5개 숫자와 보너스 볼이 일치하는 경우를 올바르게 처리한다")
    fun `handles 5 matches with bonus ball correctly`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusBall = 7
        val winningTicket = LottoTicket.from(winningNumbers.toList())
        val evaluator = LottoResultEvaluator(winningTicket, bonusBall)

        val userTicket = LottoTicket.from(listOf(1, 2, 3, 4, 5, bonusBall))
        val result = evaluator.evaluate(listOf(userTicket))

        assertEquals(1, result.bonusMatchCount)
    }

    @Test
    @DisplayName("5개 숫자만 일치하는 경우를 올바르게 처리한다")
    fun `handles 5 matches correctly`() {
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusBall = 7
        val winningTicket = LottoTicket.from(winningNumbers.toList())
        val evaluator = LottoResultEvaluator(winningTicket, bonusBall)

        val userTicket = LottoTicket.from(listOf(1, 2, 3, 4, 5, 10))
        val result = evaluator.evaluate(listOf(userTicket))

        assertEquals(1, result.getMatchCount(5))
        assertEquals(0, result.bonusMatchCount)
    }
}
