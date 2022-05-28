package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoRankTest {
    @ParameterizedTest
    @ValueSource(ints = [3, 4, 5, 6])
    fun `from을 통해 맞춘 개수에 맞는 LottoRank를 얻을 수 있다`(input: Int) {
        val numberOfMatches = NumberOfMatches(input)
        val lottoRank = LottoRank.from(numberOfMatches)

        assertThat(lottoRank.numberOfMatches).isEqualTo(numberOfMatches)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 0, 33, 8, 7])
    fun `유효하지 않은 개수를 from에 전달한다면 NOTHING을 반환한다`(input: Int) {
        val lottoRank = LottoRank.from(NumberOfMatches(input))

        assertThat(lottoRank).isEqualTo(LottoRank.NOTHING)
    }
}
