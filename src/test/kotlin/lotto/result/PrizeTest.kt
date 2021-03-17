package lotto.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PrizeTest {

    @Test
    fun `수익률은 소수점 3째자리까지 노출한다`() {
        assertThat(Prize(5_000).calculateYield(14_000)).isEqualTo(0.35)
    }
}
