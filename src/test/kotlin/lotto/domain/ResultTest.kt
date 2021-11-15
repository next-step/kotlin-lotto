package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun `등수 체크`() {
        assertThat(Result(listOf(3, 4, 5, 6)).values).isEqualTo(mapOf(3 to 1, 4 to 1, 5 to 1, 6 to 1))
    }

    @Test
    fun `이익 계산`() {
        assertThat(Result(listOf(3)).calculateProfit(Money.makeForBuyingLotto(5000))).isEqualTo(1.00)
        assertThat(Result(listOf(4)).calculateProfit(Money.makeForBuyingLotto(5000))).isEqualTo(10.0)
    }
}
