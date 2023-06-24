package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WinningTicketTest {
    @Test
    internal fun `3개의 숫자가 같은 하나의 로또가 있으면 결과는 5등이다`() {
        val winningTicket = WinningTicket(
            Lotto(
                listOf(1, 2, 3, 7, 8, 9).map { LottoNumber(it) }
            ), 10
        )
        val testLotto = Tickets(1, listOf(), TestNumGenerator())
        val score = winningTicket.score(testLotto)

        Rank.values().intersect(score.score.toSet()).size shouldBe 1
        Rank.values().intersect(score.score.toSet()).first() shouldBe Rank.FIFTH
    }

    @Test
    internal fun `5개숫자가 같고 보너스 볼을 가지고 있으면 결과는 2등이다`() {
        val winningTicket = WinningTicket(
            Lotto(
                listOf(
                    1, 2, 3, 4, 5, 9
                ).map { LottoNumber(it) }
            ), 6
        )
        val testLotto = Tickets(1, listOf(), TestNumGenerator())
        val score = winningTicket.score(testLotto)

        Rank.values().intersect(score.score).size shouldBe 1
        Rank.values().intersect(score.score).first() shouldBe Rank.SECOND
    }
}
