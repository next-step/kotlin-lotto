package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class WinningTicketTest {
    @Test
    internal fun `보너스볼을 가지고 있으면 가졌다는 결과가 나온다`() {
        val winningTicket = WinningTicket(Lotto(listOf(1, 2, 3, 4, 5, 8)), 6)
        val testLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        winningTicket.hasBonus(testLotto) shouldBe true
    }

    @Test
    internal fun `보너스볼을 안 가지고 있으면 안 가졌다는 결과가 나온다`() {
        val winningTicket = WinningTicket(Lotto(listOf(1, 2, 3, 4, 5, 8)), 7)
        val testLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        winningTicket.hasBonus(testLotto) shouldBe false
    }
}
