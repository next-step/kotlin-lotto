package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    fun `matchCount에 의해 LottoRank를 생성한다`() {
        assertThat(LottoRank.from(0)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.from(1)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.from(2)).isEqualTo(LottoRank.NONE)
        assertThat(LottoRank.from(3)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.from(4)).isEqualTo(LottoRank.THIRD)
        assertThat(LottoRank.from(5)).isEqualTo(LottoRank.SECOND)
        assertThat(LottoRank.from(6)).isEqualTo(LottoRank.FIRST)
    }
}
