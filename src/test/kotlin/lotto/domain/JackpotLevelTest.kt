package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JackpotLevelTest {

    @Test
    fun `matchCount 가 같은 value 가 반환된다`() {
        val jackpotLevel = JackpotLevel.findMatchingLevel(SIX_MATCH_COUNT, false)
        assertEquals(JackpotLevel.SIX_MATCH, jackpotLevel)
    }

    @Test
    fun `matchCount 가 같은 value 를 찾지 못하면 NO_MATCH 를 반환된다`() {
        val jackpotLevel = JackpotLevel.findMatchingLevel(DO_NOT_MATCH_COUNT, false)
        assertEquals(JackpotLevel.NO_MATCH, jackpotLevel)
    }

    @Test
    fun `5개의 번호가 같고 BonusNumber 도 같다면 'FIVE_MATCH_BONUS'를 반환한다 `() {
        val jackpotLevel = JackpotLevel.findMatchingLevel(FIVE_MATCH_COUNT, true)
        assertEquals(JackpotLevel.FIVE_MATCH_BONUS, jackpotLevel)
    }

    @Test
    fun `5개의 번호가 같고 BonusNumber 가 다르다면 'FIVE_MATCH'를 반환한다 `() {
        val jackpotLevel = JackpotLevel.findMatchingLevel(FIVE_MATCH_COUNT, false)
        assertEquals(JackpotLevel.FIVE_MATCH, jackpotLevel)
    }

    companion object {
        private const val FIVE_MATCH_COUNT = 5
        private const val SIX_MATCH_COUNT = 6
        private const val DO_NOT_MATCH_COUNT = 111
    }
}
