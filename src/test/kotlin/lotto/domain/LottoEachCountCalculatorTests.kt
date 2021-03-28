package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoEachCountCalculatorTests {
    @Test
    fun `10개를 구매하는데 4개가 수동이면 6개는 자동이다`() {
        val calculator: LottoEachCountCalculator = LottoEachCountCalculator(10, 4)

        assertThat(calculator.autoCount)
            .isEqualTo(6)
    }
}
