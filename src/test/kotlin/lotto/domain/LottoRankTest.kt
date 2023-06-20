package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun getByMatchCount() {
        // when
        val lottoRank = LottoRank.getByMatchCount(3)

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.MATCH_THREE)
    }
}
