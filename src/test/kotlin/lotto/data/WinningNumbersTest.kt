package lotto.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `WinningNumber가 특정 숫자를 가지고 있는지 확인한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningNumbers.contains(6)).isTrue()
        assertThat(winningNumbers.contains(7)).isFalse()
    }
}
