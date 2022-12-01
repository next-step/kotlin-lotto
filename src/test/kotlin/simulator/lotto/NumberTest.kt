package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class NumberTest {
    @Test
    fun `번호는 오름차순 정렬되어 있다`() {
        val number = Number(sortedSetOf(1, 2, 4, 3, 5, 6))

        assertThat(number.values).isEqualTo(setOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `번호가 6개가 아닌 경우 Exception을 발생시킨다`() {
        val numbers = sortedSetOf(1, 2, 3, 4, 5)

        assertThatIllegalArgumentException()
            .isThrownBy { Number(numbers) }
    }

    @Test
    fun `번호가 1 미만의 값이 있을 경우 Exception을 발생시킨다`() {
        val numbers = sortedSetOf(0, 1, 2, 3, 4, 5)

        assertThatIllegalArgumentException()
            .isThrownBy { Number(numbers) }
    }

    @Test
    fun `번호가 45 초과의 값이 있을 경우 Exception을 발생시킨다`() {
        val numbers = sortedSetOf(1, 2, 3, 4, 5, 46)

        assertThatIllegalArgumentException()
            .isThrownBy { Number(numbers) }
    }

    @Test
    fun `로또 번호가 다른 번호와 얼마나 일치하는지 알 수 있다`() {
        val numbers = Number(sortedSetOf(1, 2, 3, 4, 5, 7))
        val winningNumber = Number(sortedSetOf(1, 2, 3, 4, 5, 6))

        assertThat(numbers.countOfMatch(winningNumber)).isEqualTo(5)
    }
}