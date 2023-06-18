package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class BankTest {
    @Test
    internal fun `3개의 숫자가 같은 하나의 로또가 있으면 결과는 5등이다`() {
        val winningTicket = WinningTicket(listOf(1, 2, 3, 7, 8, 9))
        val testLotto = listOf(Lotto(TestNumGenerator()))
        val score = Bank.score(testLotto, winningTicket)

        score[Rank.FIFTH] shouldBe 1
        score[Rank.FOURTH] shouldBe 0
        score[Rank.THIRD] shouldBe 0
        score[Rank.FIRST] shouldBe 0
        score.keys.size shouldBe 4
    }

    @Test
    internal fun `10000을 내고 5등하나에 당첨됐으면 수익률은 50퍼다`() {
        val winningTicket = WinningTicket(listOf(1, 2, 3, 7, 8, 9))
        val testLotto = listOf(Lotto(TestNumGenerator()))
        val score = Bank.score(testLotto, winningTicket)

        Bank.calculateRateOfReturn(10000,score) shouldBe 0.5
    }

    @Test
    internal fun `10000을 내고 4등하나에 당첨됐으면 수익률은 5배다`() {
        val winningTicket = WinningTicket(listOf(1, 2, 3, 4, 8, 9))
        val testLotto = listOf(Lotto(TestNumGenerator()))
        val score = Bank.score(testLotto, winningTicket)

        Bank.calculateRateOfReturn(10000,score) shouldBe 5
    }
}
