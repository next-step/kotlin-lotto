package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JackpotLevelTest {

    @Test
    fun `matchCount 가 같은 value 가 반환된다`() {
        val jackpotLevel = JackpotLevel.getJackpotLevel(SIX_MATCH_COUNT)
        assertEquals(JackpotLevel.SIX_MATCH, jackpotLevel)
    }

    @Test
    fun `matchCount 가 같은 value 를 찾지 못하면 NO_MATCH 를 반환된다`() {
        val jackpotLevel = JackpotLevel.getJackpotLevel(DO_NOT_MATCH_COUNT)
        assertEquals(JackpotLevel.NO_MATCH, jackpotLevel)
    }

    companion object {
        private const val SIX_MATCH_COUNT = 6
        private const val DO_NOT_MATCH_COUNT = 111
    }
}
