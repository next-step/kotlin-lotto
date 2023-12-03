package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RankTest {

    @Test
    fun `1등 조건은 6개 숫자가 일치하는 경우이다`() {
        // given, when
        val rank = Rank.decideRank(6, false)

        // then
        assertEquals(Rank.FIRST, rank)
    }

    @Test
    fun `2등 조건은 5개 숫자가 일치하고, 보너스 숫자가 일치하는 경우이다`() {
        // given, when
        val rank = Rank.decideRank(5, true)

        // then
        assertEquals(Rank.SECOND, rank)
    }

    @Test
    fun `3등 조건은 5개 숫자가 일치하고, 보너스 숫자가 일치하지 않는 경우이다`() {
        // given, when
        val rank = Rank.decideRank(5, false)

        // then
        assertEquals(Rank.THIRD, rank)
    }

    @Test
    fun `4등 조건은 4개 숫자가 일치하는 경우이다`() {
        // given, when
        val rank = Rank.decideRank(4, false)

        // then
        assertEquals(Rank.FOURTH, rank)
    }

    @Test
    fun `5등 조건은 3개 숫자가 일치하는 경우이다`() {
        // given, when
        val rank = Rank.decideRank(3, false)

        // then
        assertEquals(Rank.FIFTH, rank)
    }

    @Test
    fun `일치하는 숫자가 3개 미만일 경우 당첨이 아니다`() {
        // given, when
        val ranks = listOf<Rank>(
            Rank.decideRank(2, true),
            Rank.decideRank(2, false),
            Rank.decideRank(1, true),
            Rank.decideRank(1, false),
            Rank.decideRank(0, true),
            Rank.decideRank(0, false),
        )

        // then
        ranks.forEach {
            assertEquals(false, it.isWin)
        }
    }

    @Test
    fun `7개 이상 숫자가 일치하는 경우는 없다`() {
        assertThrows<IllegalArgumentException> { Rank.decideRank(7, true) }
    }
}
