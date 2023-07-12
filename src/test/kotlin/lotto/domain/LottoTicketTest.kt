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
}
