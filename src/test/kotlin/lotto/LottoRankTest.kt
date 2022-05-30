package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class LottoRankTest {

    @Test
    fun `3개 미만의 번호는 당첨금이 없습니다`() {
        val selectRank1 = LottoRank.selectRank(1, false)
        val selectRank2 = LottoRank.selectRank(2, false)

        assertAll("로또 랭크 확인 및 당첨금 확인", {
            assertThat(selectRank1 == LottoRank.LOSE).isTrue
            assertThat(selectRank1.price).isEqualTo(0L)

            assertThat(selectRank2 == LottoRank.LOSE).isTrue
            assertThat(selectRank2.price).isEqualTo(0L)
        })
    }

    @Test
    fun `3개의 번호가 일치하면 5천원을 받습니다`() {
        val selectRank = LottoRank.selectRank(3, false)
        assertThat(selectRank == LottoRank.THREE_MATCH).isTrue
        assertThat(selectRank.price).isEqualTo(5_000L)
    }

    @Test
    fun `4개의 번호가 일치하면 5만원을 받습니다`() {
        val selectRank = LottoRank.selectRank(4, false)
        assertThat(selectRank == LottoRank.FOUR_MATCH).isTrue
        assertThat(selectRank.price).isEqualTo(50_000L)
    }

    @Test
    fun `5개의 번호가 일치하면 150만원을 받습니다`() {
        val selectRank = LottoRank.selectRank(5, false)
        assertThat(selectRank == LottoRank.FIVE_MATCH).isTrue
        assertThat(selectRank.price).isEqualTo(1_500_000L)
    }

    @Test
    fun `5개의 번호가 일치하면하고 보너스 번호가 맞으면 3000만원을 받습니다`() {
        val selectRank = LottoRank.selectRank(5, true)
        assertThat(selectRank == LottoRank.FIVE_MATCH_WITH_BONUS).isTrue
        assertThat(selectRank.price).isEqualTo(30_000_000L)
    }

    @Test
    fun `6개의 번호가 일치하면 20억을 받습니다`() {
        val selectRank = LottoRank.selectRank(6, false)
        assertThat(selectRank == LottoRank.SIX_MATCH).isTrue
        assertThat(selectRank.price).isEqualTo(2_000_000_000L)
    }
}
