package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun how_can_get_money() {
        val money = 1000
        val list = listOf("1", "2", "3", "4", "5", "6")
        val lottos = listOf(Lotto(list, 3))
        val result = Result(lottos)

        val rateOfReturn = result.getRateOfReturn(money)

        assertThat(rateOfReturn).isEqualTo(5.0)
    }

    @Test
    fun how_match_lotto() {
        val list = listOf("1", "2", "3", "4", "5", "6")
        val lottos = listOf(Lotto(list, 3), Lotto(list, 4), Lotto(list, 3))
        val result = Result(lottos)

        val matchResult = result.getAllMatchResult()

        assertThat(matchResult).isEqualTo(listOf(2, 1, 0, 0))
    }
}
