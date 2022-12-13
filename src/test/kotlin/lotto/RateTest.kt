package lotto

import lotto.domain.Amount
import lotto.domain.Rate
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class RateTest {

    @Test
    fun `수익률을 구한다`() {
        val totalWinAmount = Amount(14_000)
        val amount = Amount(5_000)
        val rate = Rate(totalWinAmount, amount).toReturn()
        assertThat(rate).isEqualTo(0.35)
    }
}