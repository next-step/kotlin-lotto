package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class TicketsTest {
    @Test
    internal fun `요구한 수만큼 로또티켓이 생성된다`() {
        Tickets(5, AutoNumGenerator()).tickets.size shouldBe 5
    }
}
