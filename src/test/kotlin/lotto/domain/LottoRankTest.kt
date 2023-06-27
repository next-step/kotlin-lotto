package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoRankTest {

    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6])
    @ParameterizedTest
    fun getRank(matchCount: Int) {
        // when
        val lottoRank = LottoRank.getRank(LottoMatchCount(matchCount, false))

        // then
        assertThat(lottoRank).isEqualTo(
            when (matchCount) {
                0 -> LottoRank.NONE
                1 -> LottoRank.NONE
                2 -> LottoRank.NONE
                3 -> LottoRank.FOURTH
                4 -> LottoRank.THIRD
                5 -> LottoRank.SECOND
                6 -> LottoRank.FIRST
                else -> {}
            }
        )
    }

    fun `getRank-매칭수가 5개이고, 보너스 번호를 포함하는 경우 BONUS_SECOND 를 반환한다`() {
        // when
        val lottoRank = LottoRank.getRank(LottoMatchCount(5, true))

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.BONUS_SECOND)
    }
}
