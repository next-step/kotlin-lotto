package lotto

import domain.Lottery
import fixture.LotteryFixture.TEST_MOCK_LOTTERY
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTest {

    @Test
    fun `로또는 중복되지 않는 6개의 랜덤 숫자를 가진다`() {
        val lottery = Lottery(TEST_MOCK_LOTTERY)

        val numbers = lottery.numbers

        assertThat(numbers.numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또의 가격은 1000원이다`() {
        val lottery = Lottery(TEST_MOCK_LOTTERY)

        assertThat(lottery.price).isEqualTo(1000)
    }
}
