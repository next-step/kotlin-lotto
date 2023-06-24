package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class TicketsTest {
    @Test
    internal fun `요구한 수만큼 로또티켓이 생성된다`() {
        Tickets(5, listOf(), AutoNumGenerator()).tickets.size shouldBe 5
    }

    @Test
    internal fun `수동으로 생성한 티켓이 합쳐져 요구한 수만큼 생성된다`() {
        Tickets(
            5, listOf(
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
            ), AutoNumGenerator()
        ).tickets.size shouldBe 5
    }
}
