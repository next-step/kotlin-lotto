package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class WinningNumberTest {
    @Test
    fun `당첨 번호는 번호 6개와 보너스 숫자 1개로 구성된다`() {
        val numbers = Numbers(listOf(1, 2, 3, 4, 5, 6).map { Number(it) })
        val winningNumbers = WinningNumber(numbers, Number(7))

        assertThat(winningNumbers.numbers)
    }

    @Test
    fun `당첨 번호의 번호와 보너스 번호는 중복될 수 없다 `() {
        val numbers = Numbers(listOf(1, 2, 3, 4, 5, 6).map { Number(it) })
        assertThrows<IllegalArgumentException> {
            WinningNumber(numbers, Number(6))
        }
    }
}
