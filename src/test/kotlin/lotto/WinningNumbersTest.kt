package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class WinningNumbersTest {
    @Test
    fun `당첨 번호는 6개의 숫자로 이뤄져 있다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    fun `당첨 번호는 1~49 사이의 숫자들이다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningNumbers(listOf(0, 1, 2, 3, 4, 5)) }
    }

    @Test
    fun `당첨 번호는 숫자들이 겹치면 안된다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningNumbers(listOf(1, 1, 2, 3, 4, 5)) }
    }
}