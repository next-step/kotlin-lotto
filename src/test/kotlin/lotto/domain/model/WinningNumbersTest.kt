package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `WinningNumbers는 당첨 번호 목록을 보관한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers)

        assertThat(winningNumbers.value).isEqualTo(numbers)
    }
}
