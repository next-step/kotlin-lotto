package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.shouldSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `빈 로또를 전달하면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { LottoTicket(listOf()) }
    }

    @Test
    fun `로또 티켓은 자동 로또 수와 수동 로또 수를 갖는다`() {
        val lottos = listOf(
            Lotto.of(listOf(1, 2, 3, 4, 5, 6), LottoType.AUTO),
            Lotto.of(listOf(1, 2, 3, 4, 5, 6), LottoType.AUTO),
            Lotto.of(listOf(1, 2, 3, 4, 5, 6), LottoType.MANUAL),
        )

        val lottoTicket = LottoTicket(lottos)

        shouldSpec {
            lottoTicket.countOfAutoLotto shouldBe 2
            lottoTicket.countOfManualLotto shouldBe 1
        }
    }

    @Test
    fun `로또 티켓은 당첨 로또를 받아 당첨 결과를 반환한다`() {
        val lottos = listOf(
            Lotto.of(listOf(1, 2, 3, 4, 5, 6), LottoType.AUTO),
            Lotto.of(listOf(1, 2, 3, 4, 5, 6), LottoType.AUTO),
            Lotto.of(listOf(1, 2, 3, 4, 5, 7), LottoType.MANUAL),
        )
        val lottoTicket = LottoTicket(lottos)
        val winningLotto = WinningLotto.from(listOf(1, 2, 3, 4, 5, 6), 7)

        val matchResult = lottoTicket.match(winningLotto)

        shouldSpec {
            matchResult.countOf(Rank.FIRST) shouldBe 2
            matchResult.countOf(Rank.SECOND) shouldBe 1
            matchResult.countOf(Rank.THIRD) shouldBe 0
            matchResult.countOf(Rank.FOURTH) shouldBe 0
            matchResult.countOf(Rank.FIFTH) shouldBe 0
        }
    }
}
