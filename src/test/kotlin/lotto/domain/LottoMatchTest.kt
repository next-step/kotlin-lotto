package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMatchTest {

    @ParameterizedTest
    @ValueSource(longs = [-1, 1, 2, 4, 100])
    fun getProfit() {
        val matchTotalCount = 3L
        val lottoRank = LottoRank.FIRST_PLACE
        val lottoMatch = LottoMatch(lottoRank, matchTotalCount)

        val resultProfit = lottoMatch.getProfit()

        assertThat(resultProfit).isEqualTo(matchTotalCount * lottoRank.reward)
    }
}
