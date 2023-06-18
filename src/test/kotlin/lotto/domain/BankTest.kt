package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class BankTest {
    @Test
    internal fun `3개의 숫자가 같은 하나의 로또가 있으면 결과는 5등이다`() {
        val winningTicket = WinningTicket(listOf(1, 2, 3, 7, 8, 9))
        val testLotto = listOf(Lotto(TestNumGenerator()))
        val score = Bank().score(testLotto, winningTicket)

        score[Rank.FIFTH] shouldBe 1
        score[Rank.FOURTH] shouldBe 0
        score[Rank.THIRD] shouldBe 0
        score[Rank.FIRST] shouldBe 0
        score.keys.size shouldBe 4
    }
}
