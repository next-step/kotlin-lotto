package lotto

import lotto.domain.Statistics
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StatisticsTest {

    @ParameterizedTest
    @CsvSource(value = ["50000|14000|3.57", "5000|14000|0.35"], delimiterString = "|")
    fun `로또 수익률 계산이 올바르게 계산되는지 확인합니다`(prizeAllMoney: Int, lottoBuyMoney: Int, result: Double) {
        assertThat(Statistics.calculation(prizeAllMoney, lottoBuyMoney)).isEqualTo(result)
    }

}