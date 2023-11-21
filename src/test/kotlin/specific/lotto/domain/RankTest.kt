package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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
}
