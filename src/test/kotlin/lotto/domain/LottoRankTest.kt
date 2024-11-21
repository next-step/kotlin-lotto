package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `matchCount에 의해 LottoRank를 생성한다`() {
        assertThat(LottoRank.from(0, false)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.from(1, false)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.from(2, false)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.from(3, false)).isEqualTo(LottoRank.FIFTH)
        assertThat(LottoRank.from(4, false)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.from(5, false)).isEqualTo(LottoRank.THIRD)
        assertThat(LottoRank.from(5, true)).isEqualTo(LottoRank.SECOND)
        assertThat(LottoRank.from(6, false)).isEqualTo(LottoRank.FIRST)
    }
}
