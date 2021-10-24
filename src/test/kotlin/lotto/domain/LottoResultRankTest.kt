package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoResultRankTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `일치 개수가 0~2개 인 경우 MISSED LottoResultRank 를 반환한다`(input: Int) {
        val rank = LottoResultRank.getRank(input)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.MISSED)
    }

    @Test
    fun `일치 개수가 3개 인 경우 FIFTH LottoResultRank 를 반환한다`() {
        val rank = LottoResultRank.getRank(3)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.FIFTH)
    }

    @Test
    fun `일치 개수가 4개 인 경우 FOURTH LottoResultRank 를 반환한다`() {
        val rank = LottoResultRank.getRank(4)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.FOURTH)
    }

    @Test
    fun `일치 개수가 5개 인 경우 THIRD LottoResultRank 를 반환한다`() {
        val rank = LottoResultRank.getRank(5)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.THIRD)
    }

    @Test
    fun `일치 개수가 6개 인 경우 FIRST LottoResultRank 를 반환한다`() {
        val rank = LottoResultRank.getRank(6)

        Assertions.assertThat(rank).isNotNull
        Assertions.assertThat(rank).isEqualTo(LottoResultRank.FIRST)
    }
}
