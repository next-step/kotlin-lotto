package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoRankTest {
    @ParameterizedTest
    @CsvSource(value = ["3;true", "4;false", "5;false", "5;true", "6;false"], delimiter = ';')
    fun `of를 통해 맞춘 개수에 맞는 LottoRank를 얻을 수 있다`(matchNumber: Int, isBonusBallMatched: Boolean) {
        val numberOfMatches = NumberOfMatches(matchNumber)
        val lottoRank = LottoRank.of(numberOfMatches, isBonusBallMatched)

        assertThat(lottoRank.numberOfMatches).isEqualTo(numberOfMatches)
        assertThat(lottoRank.needToMatchBonusBall).isEqualTo(matchNumber == 5 && isBonusBallMatched)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 0, 33, 8, 7])
    fun `유효하지 않은 개수를 of에 전달한다면 NOTHING을 반환한다`(input: Int) {
        val lottoRank = LottoRank.of(NumberOfMatches(input), false)

        assertThat(lottoRank).isEqualTo(LottoRank.NOTHING)
    }

    @Test
    fun `winnerPlace를 통해 당첨 됐을 때의 Rank만 가져올 수 있다`() {
        val lottoRanks = LottoRank.winnerPlace()

        assertThat(lottoRanks).doesNotContainSequence(LottoRank.NOTHING)
    }
}
