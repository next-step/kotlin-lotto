package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `LottoRank를 생성한다`() {
        assertThat(LottoRank.of(6, false)).isEqualTo(LottoRank.FIRST)
        assertThat(LottoRank.of(6, true)).isEqualTo(LottoRank.FIRST)
        assertThat(LottoRank.of(5, true)).isEqualTo(LottoRank.SECOND)
        assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD)
        assertThat(LottoRank.of(4,true)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.of(3,true)).isEqualTo(LottoRank.FIFTH)
        assertThat(LottoRank.of(2, true)).isEqualTo(LottoRank.MISS)
    }
}
