package lotto

import domain.Lottery
import fixture.LotteryFixture.TEST_LOTTERY_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTest {

    @Test
    fun `로또의 한장 가격은 1000원이다`() {
        val lottery = Lottery(TEST_LOTTERY_NUMBERS)

        assertThat(lottery.price).isEqualTo(1000)
    }

    @Test
    fun `로또는 로또번호들을 가진다`() {
        val lottery = Lottery(TEST_LOTTERY_NUMBERS)

        assertThat(lottery).isNotNull
    }
}
