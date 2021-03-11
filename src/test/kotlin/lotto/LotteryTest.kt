package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTest {

    @Test
    fun `로또는 중복되지 않는 6개의 랜덤 숫자를 가진다`() {
        val lottery = Lottery(listOf(1, 3, 5, 6, 2, 8))

        assertThat(lottery.numbers.size).isEqualTo(5)
    }

    @Test
    fun `로또의 가격은 1000원이다`() {
        val lottery = Lottery(listOf(5))

        assertThat(lottery.price).isEqualTo(1000)
    }
}
