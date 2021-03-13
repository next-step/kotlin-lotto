package domain

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
}
