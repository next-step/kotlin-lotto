package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RankTest {
    @Test
    fun `당첨번호가 6개 맞았을 때 FIRST`() {
        val actual = Rank.findBy(6, false)

        assertEquals(Rank.FIRST, actual)
    }

    @Test
    fun `당첨번호 5개, 보너스 번호가 맞았을 때 SECOND`() {
        val actual = Rank.findBy(5, true)

        assertEquals(Rank.SECOND, actual)
    }

    @Test
    fun `당첨번호 5개, 보너스 번호가 안 맞았을 때 THIRD`() {
        val actual = Rank.findBy(5, false)

        assertEquals(Rank.THIRD, actual)
    }

    @Test
    fun `당첨번호 4개 맞았을 때 FOURTH`() {
        val actual = Rank.findBy(4, false)

        assertEquals(Rank.FOURTH, actual)
    }

    @Test
    fun `당첨번호 3개 맞았을 때 FIFTH`() {
        val actual = Rank.findBy(3, false)

        assertEquals(Rank.FIFTH, actual)
    }

    @ValueSource(ints = [0, 1, 2])
    @ParameterizedTest
    fun `당첨번호 2개, 1개, 0개 맞았을 때 BLANK`(matchCount: Int) {
        val actual = Rank.findBy(matchCount, false)

        assertEquals(Rank.BLANK, actual)
    }
}
