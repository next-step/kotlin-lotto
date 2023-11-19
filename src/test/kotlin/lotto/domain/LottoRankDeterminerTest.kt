package lotto.domain

import lotto.enum.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoRankDeterminerTest {

    private val rankDeterminer = LottoRankDeterminer()

    @Test
    @DisplayName("6개 번호 일치 시 1등 반환")
    fun `6개 번호 일치 시 1등 반환`() {
        assertEquals(Rank.FIRST, rankDeterminer.determineRank(6, false))
    }

    @Test
    @DisplayName("5개 번호 일치 및 보너스 볼 일치 시 2등 반환")
    fun `5개 번호 일치 및 보너스 볼 일치 시 2등 반환`() {
        assertEquals(Rank.SECOND, rankDeterminer.determineRank(5, true))
    }

    @Test
    @DisplayName("5개 번호만 일치하는 경우 3등 반환")
    fun `5개 번호만 일치하는 경우 3등 반환`() {
        assertEquals(Rank.THIRD, rankDeterminer.determineRank(5, false))
    }

    @Test
    @DisplayName("4개 번호 일치 시 4등 반환")
    fun `4개 번호 일치 시 4등 반환`() {
        assertEquals(Rank.FOURTH, rankDeterminer.determineRank(4, false))
    }

    @Test
    @DisplayName("3개 번호 일치 시 5등 반환")
    fun `3개 번호 일치 시 5등 반환`() {
        assertEquals(Rank.FIFTH, rankDeterminer.determineRank(3, false))
    }

    @Test
    @DisplayName("2개 번호 이하 일치 시 당첨 실패")
    fun `2개 번호 이하 일치 시 당첨 실패`() {
        assertEquals(Rank.MISS, rankDeterminer.determineRank(2, false))
        assertEquals(Rank.MISS, rankDeterminer.determineRank(1, false))
        assertEquals(Rank.MISS, rankDeterminer.determineRank(0, false))
    }
}
