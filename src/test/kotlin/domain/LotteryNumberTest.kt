package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LotteryNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 46, 90, -10])
    fun `0부터 45가 아닌 숫자가 들어왔을 때 예외를 처리한다`(wrongNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LotteryNumber.from(wrongNumber)
        }
    }

    @Test
    fun `로또 번호는 중복되면 안된다`() {
        val lotteryNumbers = LotteryNumbers(listOf(1, 1, 2, 3, 4, 5, 7))

        assertThat(lotteryNumbers.numbers.size).isEqualTo(6)
    }
}
