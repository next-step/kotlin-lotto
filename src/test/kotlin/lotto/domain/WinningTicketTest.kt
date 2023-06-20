package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WinningTicketTest {
    @Test
    internal fun `지난주 로또와 같은 숫자를 가진 갯수가 계산된다`() {
        val winningTicket = WinningTicket(listOf(1, 2, 3, 8, 9, 10))
        winningTicket.score(Lotto(TestNumGenerator())) shouldBe 3
    }
}
