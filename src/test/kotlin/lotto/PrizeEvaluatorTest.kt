package lotto

import lotto.domain.Prize
import lotto.domain.PrizeEvaluator
import lotto.domain.Ticket
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeEvaluatorTest {

    @Test
    fun `번호가 3자리 같다면 5000원을 상금으로 탄다`() {
        // given
        val userNumber = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = listOf(1, 2, 3, 7, 8, 9)

        val userTicket = Ticket(userNumber)
        val winningTicket = Ticket(winningNumber)

        // when
        val prize = PrizeEvaluator.evaluate(userTicket, winningTicket)

        // then
        assertEquals(Prize(5000), prize)
    }

    @Test
    fun `번호가 4자리 같다면 50000원을 상금으로 탄다`() {
        // given
        val userNumber = listOf(1, 2, 3, 4, 5, 6)
        val winningNumber = listOf(1, 2, 3, 4, 8, 9)

        val userTicket = Ticket(userNumber)
        val winningTicket = Ticket(winningNumber)

        // when
        val prize = PrizeEvaluator.evaluate(userTicket, winningTicket)

        // then
        assertEquals(Prize(50000), prize)
    }

    @Test
    fun `2000 원으로 2개의 로또를 샀을때, 3개 일치하는 로또가 1개 있다면 수익률은 250% 입니다`() {
        // given
        val userNumber1 = listOf(1, 2, 3, 10, 11, 12)
        val userNumber2 = listOf(7, 8, 9, 10, 11, 12)
        val winningNumber = listOf(1, 2, 3, 30, 31, 32)

        val userTickets = listOf(Ticket(userNumber1), Ticket(userNumber2))
        val winningTicket = Ticket(winningNumber)

        // when
        val roi = PrizeEvaluator.calculateROI(PrizeEvaluator.evaluateTotalPrize(userTickets, winningTicket), 2000)

        // then
        assertEquals(2.5, roi)
    }
}
