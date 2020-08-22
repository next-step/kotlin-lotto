package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    val winningNumber = listOf(1, 2, 3, 14, 15, 16)
    val winningNumberBonus = listOf(1, 2, 3, 4, 5, 17)

    @Test
    fun testExpectedExceptionWithSuperType() {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { Lotto().validateSize(setOf(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    @DisplayName("Ticket")
    fun ticketsTest() {
        assertThat(Lottos(14).purchasedLotto.size).isEqualTo(14)
    }

    @Test
    fun `bonusCheck`() {
        assertThat(Lotto().getPrizeWithBonus(winningNumberBonus, 7)).isEqualTo(Rank.FIVE_BONUS_MATCH)
    }
}
