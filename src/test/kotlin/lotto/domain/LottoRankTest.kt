package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `LottoRank를 생성한다`() {
        assertThat(LottoRank.of(6)).isEqualTo(LottoRank.FIRST)
        assertThat(LottoRank.of(5)).isEqualTo(LottoRank.SECOND)
        assertThat(LottoRank.of(4)).isEqualTo(LottoRank.THIRD)
        assertThat(LottoRank.of(3)).isEqualTo(LottoRank.FOURTH)
        assertThat(LottoRank.of(2)).isEqualTo(LottoRank.MISS)
    }
}
