package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    internal fun putRank() {
        val result = LottoResult()
        result.putRank(Rank.FIRST)
        result.putRank(Rank.SECOND)
        result.putRank(Rank.SECOND)
        result.putRank(Rank.MISS)

        assertThat(result.countByRank(Rank.FIRST)).isEqualTo(1)
        assertThat(result.countByRank(Rank.SECOND)).isEqualTo(2)
        assertThat(result.countByRank(Rank.THIRD)).isEqualTo(0)
        assertThat(result.countByRank(Rank.MISS)).isEqualTo(1)
    }
}
