package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class WinningNumberTest {
    @Test
    fun `당첨 번호는 번호 6개와 보너스 숫자 1개로 구성된다`() {
        val winningNumber = WinningNumber(Number(sortedSetOf(1, 2, 3, 4, 5, 6)), 7)

        assertThat(winningNumber.number)
    }

    @Test
    fun `보너스 번호는 로또 번호의 최댓값을 넘을순 없다`() {
        val invalidNumber = Number.MAX_NUMBER + 1
        assertThrows<IllegalArgumentException> {
            WinningNumber(Number(sortedSetOf(1, 2, 3, 4, 5, 6)), invalidNumber)
        }
    }

    @Test
    fun `보너스 번호는 로또 번호의 최솟값 보다 작을순 없다`() {
        val invalidNumber = Number.MIN_NUMBER - 1
        assertThrows<IllegalArgumentException> {
            WinningNumber(Number(sortedSetOf(1, 2, 3, 4, 5, 6)), invalidNumber)
        }
    }

    @Test
    fun `당첨 번호의 번호와 보너스 번호는 중복될 수 없다 `() {
        assertThrows<IllegalArgumentException> {
            WinningNumber(Number(sortedSetOf(1, 2, 3, 4, 5, 6)), 6)
        }
    }
}
