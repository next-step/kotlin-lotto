package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 티켓은 1개 이상의 로또를 포함해야 한다`() {
        val lottos =
            listOf(
                Lotto.create(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.create(listOf(7, 8, 9, 10, 11, 12)),
            )
        val ticket = LottoTicket(lottos)

        ticket.lottos.shouldHaveSize(2)
    }

    @Test
    fun `로또 티켓은 1개 이상의 로또를 포함하지 않으면 예외 발생한다`() {
        shouldThrow<IllegalArgumentException> { LottoTicket(emptyList()) }
            .message shouldBe "로또 티켓은 적어도 하나의 로또를 포함해야 합니다."
    }
}
