package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun how_can_get_money() {
        val money = 1_000
        val ranks = mutableMapOf("5등" to 1, "4등" to 0, "3등" to 0, "2등" to 0, "1등" to 0)
        val result = Result(ranks)

        val rateOfReturn = result.getRateOfReturn(money)

        assertThat(rateOfReturn).isEqualTo(5.0)
    }
}
