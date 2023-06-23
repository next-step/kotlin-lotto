package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningTicketTest {
    @Test
    internal fun `3개의 숫자가 같은 하나의 로또가 있으면 결과는 5등이다`() {
        val winningTicket = WinningTicket(Lotto(listOf(1, 2, 3, 7, 8, 9)), 10)
        val testLotto = Tickets(1, TestNumGenerator())
        val score = winningTicket.score(testLotto)

        Rank.values().intersect(score).size shouldBe 1
        Rank.values().intersect(score).first() shouldBe Rank.FIFTH
    }

    @Test
    internal fun `5개숫자가 같고 보너스 볼을 가지고 있으면 결과는 2등이다`() {
        val winningTicket = WinningTicket(Lotto(listOf(1, 2, 3, 4, 5, 8)), 6)
        val testLotto = Tickets(1, TestNumGenerator())
        val score = winningTicket.score(testLotto)

        Rank.values().intersect(score).size shouldBe 1
        Rank.values().intersect(score).first() shouldBe Rank.SECOND
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,11,8,9;7;0.5", "1,2,3,4,8,9;7;5"], delimiter = ';')
    internal fun `동일한 개수에 등수가 결정되고 그에 따른 수익률이 계산된다`(winningNums: String, bonus: Int, result: Float) {
        val winningTicket = WinningTicket(Lotto(winningNums.split(",").map { it.toInt() }), bonus)
        val testLotto = Tickets(1, TestNumGenerator())
        val score = winningTicket.score(testLotto)

        winningTicket.calculateRateOfReturn(10000, score) shouldBe result
    }
}
