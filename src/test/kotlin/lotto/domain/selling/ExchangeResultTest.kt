package lotto.domain.selling

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ExchangeResultTest {

    @DisplayName("수익률을 계산한다")
    @Test
    fun calculateRateOfReturn() {
        val exchangeResult = ExchangeResult(hashMapOf(4 to 1, 3 to 1, 2 to 3))
        assertThat(exchangeResult.calculateRateOfReturn()).isEqualTo(55000 / 5000f)
    }
}
