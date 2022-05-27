package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LottoRankTest {

    @Test
    fun `RANK 확인`() {
        val selectRank1 = LottoRank.selectRank(1)
        val selectRank2 = LottoRank.selectRank(2)
        val selectRank3 = LottoRank.selectRank(3)

        assertAll("Ranks", {
            assertThat(selectRank1 == LottoRank.LOSE).isTrue
            assertThat(selectRank1.price).isEqualTo(0L)

            assertThat(selectRank2 == LottoRank.LOSE).isTrue
            assertThat(selectRank2.price).isEqualTo(0L)

            assertThat(selectRank3 == LottoRank.THREE_MATCH).isTrue
            assertThat(selectRank3.price).isEqualTo(5_000L)
        })
    }
}
