package lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ProfitTest {
    @ParameterizedTest
    @CsvSource("14000, 5000, 0.36", "20000, 400000000, 20000.00")
    fun `당첨금액과 구매금액을 비교하여 수익율을 계산한다`(inputMoney: Int, jackpots: Int, expectedProfit: String) {
        val profit = Profit.calculate(inputMoney, jackpots)

        assertThat(profit).isEqualTo(expectedProfit)
    }
}
