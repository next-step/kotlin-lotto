package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteriesTest {
    @Test
    fun `입력 개수만큼 로또를 생성한다`() {
        val createdLotteries = Lotteries.of(6)

        assertThat(createdLotteries.lotteries.size).isEqualTo(6)
    }
}
