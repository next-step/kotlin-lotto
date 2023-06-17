package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RateCalculatorTest {

    @ParameterizedTest
    @CsvSource("14000, 5000")
    fun `산정 된 당첨 정보를 통해 구입한 금액과의 수익률을 구할 수 있다`(money: Int, winningMoney: Int) {
        val actual = RateCalculator().calculateRateOfReturn(money, winningMoney)
        actual shouldBe 0.35
    }
}
