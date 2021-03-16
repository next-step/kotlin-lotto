package lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProfitTest {
    @Test
    fun `당첨금액과 구매금액을 비교하여 수익율을 계산한다`() {
        val profit = Profit.calculate(14000.0, 5000.0)

        assertThat(profit).isEqualTo("0.36")
    }
}
