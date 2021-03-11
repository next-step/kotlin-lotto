package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryNumbersTest {
    @Test
    fun `로또의 중복되지 않는 6자리 랜덤 숫자를 만든다`() {
        val lotteryNumbers = LotteryNumbers()

        val numbers = lotteryNumbers.makeLotteryNumbers(RandomNumbers())

        assertThat(numbers.size).isEqualTo(6)
    }
}
