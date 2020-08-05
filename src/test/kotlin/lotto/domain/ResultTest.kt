package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun get_rate_of_return() {
        val money = 1_000
        val rank = Rank()
        rank.addRank(3)
        val result = Result(money, rank.ranks)

        val rateOfReturn = result.getRateOfReturn()

        assertThat(rateOfReturn).isEqualTo(5.0)
    }
}
