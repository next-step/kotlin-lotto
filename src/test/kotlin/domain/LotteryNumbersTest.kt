package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryNumbersTest {
    @Test
    fun `6개의 로또 번호를 가진다`() {
        val lotteryNumbers = LotteryNumbers(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotteryNumbers.numbers).containsExactlyInAnyOrder(
            LotteryNumber.from(1),
            LotteryNumber.from(2),
            LotteryNumber.from(3),
            LotteryNumber.from(4),
            LotteryNumber.from(5),
            LotteryNumber.from(6)
        )
    }
}
