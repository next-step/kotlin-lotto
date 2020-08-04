package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun how_can_get_money() {
        val money = 1_000
        val ranks = mutableMapOf(3 to 1, 4 to 0, 5 to 0, 6 to 0)
        val result = Result(ranks)

        val rateOfReturn = result.getRateOfReturn(money)

        assertThat(rateOfReturn).isEqualTo(5.0)
    }

    @Test
    fun how_match_lotto() {
        val ranks = mutableMapOf(3 to 2, 4 to 1, 5 to 0, 6 to 0)
        val result = Result(ranks)

        val matchResult = result.getRanks()

        assertThat(matchResult).isEqualTo(listOf(2, 1, 0, 0))
    }
}
