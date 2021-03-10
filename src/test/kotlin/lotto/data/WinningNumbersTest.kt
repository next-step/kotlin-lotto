package lotto.data

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `WinningNumber가 특정 숫자를 가지고 있는지 확인한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        assertThat(winningNumbers.contains(6)).isTrue()
        assertThat(winningNumbers.contains(7)).isFalse()
    }

    @Test
    fun `로또 번호의 개수인 6개보다 많이 가지고 있다`() {
        assertThatThrownBy { WinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호의 개수인 6개보다 적게 가지고 있다`() {
        assertThatThrownBy { WinningNumbers(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
