package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    internal fun `일치하는 숫자 갯수`() {
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val matchCount = winningNumbers.matchCount(lotto)
        assertThat(matchCount).isEqualTo(6)
    }
}
