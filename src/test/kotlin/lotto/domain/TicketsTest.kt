package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class TicketsTest {
    @Test
    internal fun `요구한 수만큼 로또티켓이 생성된다`() {
        Tickets(5, MarkingPaper(), AutoNumGenerator()).tickets.size shouldBe 5
    }

    @Test
    internal fun `수동으로 생성한 티켓이 합쳐져 요구한 수만큼 생성된다`() {
        Tickets(
            5, MarkingPaper(
                listOf(
                    Lotto(
                        listOf(
                            LottoNumber(1),
                            LottoNumber(2),
                            LottoNumber(3),
                            LottoNumber(4),
                            LottoNumber(5),
                            LottoNumber(6)
                        )
                    )
                )
            ), AutoNumGenerator()
        ).tickets.size shouldBe 5
    }

    @Test
    internal fun `3개의 숫자가 같은 하나의 로또가 있으면 결과는 5등이다`() {
        val winningTicket = WinningTicket(
            Lotto(
                listOf(1, 2, 3, 7, 8, 9).map { LottoNumber(it) }
            ), LottoNumber(10)
        )
        val testLotto = Tickets(1, MarkingPaper(), TestNumGenerator())
        val score = testLotto.score(winningTicket)

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
            ), LottoNumber(6)
        )
        val testLotto = Tickets(1, MarkingPaper(), TestNumGenerator())
        val score = testLotto.score(winningTicket)

        Rank.values().intersect(score.score).size shouldBe 1
        Rank.values().intersect(score.score).first() shouldBe Rank.SECOND
    }
}
