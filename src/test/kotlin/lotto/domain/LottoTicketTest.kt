package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `빈 로또를 전달하면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { LottoTicket(listOf()) }
    }

    @Test
    fun `숫자 목록 여러개를 받아 로또 티켓을 생성한다`() {
        val expected = LottoTicket(
            listOf(
                Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
            )
        )
        val lottos = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 6),
        )

        val lottoTicket = LottoTicket.from(lottos)

        lottoTicket shouldBe expected
    }

    @Test
    fun `당첨 로또를 받아 당첨 결과를 반환한다`() {
        val lottos = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 7, 8),
        )
        val lottoTicket = LottoTicket.from(lottos)
        val winningLotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))

        val matches = lottoTicket.match(winningLotto)

        matches shouldBe MatchResult(listOf(Match.SIX, Match.FIVE, Match.FOUR))
    }

    @Test
    fun `당첨 결과가 없으면 빈 리스트를 반환한다`() {
        val lottos = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 7, 8),
        )
        val lottoTicket = LottoTicket.from(lottos)
        val winningLotto = Lotto.from(listOf(7, 8, 9, 10, 11, 12))

        val matches = lottoTicket.match(winningLotto)

        matches shouldBe MatchResult()
    }
}
