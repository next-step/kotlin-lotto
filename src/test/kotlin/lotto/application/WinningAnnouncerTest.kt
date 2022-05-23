package lotto.application

import lotto.domain.Lotto
import lotto.domain.Price
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningAnnouncerTest {

    @Test
    fun `winning doesn't depend on the order of numbers`() {
        val lotteries = listOf(
            Lotto(2, 1, 3, 5, 4, 6),
            Lotto(11, 12, 13, 14, 15, 16),
            Lotto(21, 22, 23, 24, 25, 26)
        )

        val winner = Lotto(listOf(1, 2, 3, 4, 5, 6), Price.FIRST)

        val result = WinningAnnouncer.announce(winner, lotteries)

        assertThat(result).filteredOn { it.price == Price.FIRST }
            .first()
            .isNotNull
    }
}
