package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class LottoRankTest {

    @Test
    fun `RANK 확인`() {
        val selectRank1 = LottoRank.selectRank(1)
        val selectRank2 = LottoRank.selectRank(2)
        val selectRank3 = LottoRank.selectRank(3)
        val selectRank4 = LottoRank.selectRank(4)
        val selectRank5 = LottoRank.selectRank(5)
        val selectRank6 = LottoRank.selectRank(6)

        assertAll("Ranks", {
            assertThat(selectRank1 == LottoRank.LOSE).isTrue
            assertThat(selectRank1.price).isEqualTo(0L)

            assertThat(selectRank2 == LottoRank.LOSE).isTrue
            assertThat(selectRank2.price).isEqualTo(0L)

            assertThat(selectRank3 == LottoRank.THREE_MATCH).isTrue
            assertThat(selectRank3.price).isEqualTo(5_000L)

            assertThat(selectRank4 == LottoRank.FOUR_MATCH).isTrue
            assertThat(selectRank4.price).isEqualTo(50_000L)

            assertThat(selectRank5 == LottoRank.FIVE_MATCH).isTrue
            assertThat(selectRank5.price).isEqualTo(1_500_000L)

            assertThat(selectRank6 == LottoRank.SIX_MATCH).isTrue
            assertThat(selectRank6.price).isEqualTo(2_000_000_000L)
        })
    }
}
