package lotto

import lotto.domain.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `당첨 번호를 입력받는다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5))
        assertThat(winningNumbers.numbers).containsExactly(1, 2, 3, 4, 5)
    }
}
