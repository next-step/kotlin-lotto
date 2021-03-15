package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryFactoryTest {
    @Test
    fun `금액에 따라 로또 생성 개수를 정해진다`() {
        val factory = LotteryFactory(5000)

        val count = factory.calculateLotteryCountByPrice()

        assertThat(count).isEqualTo(5)

    }
}
