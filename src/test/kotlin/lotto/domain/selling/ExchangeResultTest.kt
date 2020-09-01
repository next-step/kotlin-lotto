package lotto.domain.selling

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ExchangeResultTest {

    @DisplayName("수익률을 계산한다")
    @Test
    fun calculateRateOfReturn() {
        val exchangeResult = ExchangeResult(1230, hashMapOf(Rank.FIFTH to 1))
        assertThat(exchangeResult.rateOfReturn.toDouble()).isEqualTo(4.06)
    }
}
