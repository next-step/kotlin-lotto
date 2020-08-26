package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {

    val winningNumberBonus = listOf(1, 2, 3, 4, 5, 17)

    @Test
    fun testExpectedExceptionWithSuperType() {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { Lotto(setOf(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    fun `bonusCheck`() {
        assertThat(
            Lotto(setOf(1, 2, 3, 4, 5, 7)).getPrizeWithBonus(
                winningNumberBonus,
                7
            )
        ).isEqualTo(Rank.FIVE_BONUS_MATCH)
    }
}
