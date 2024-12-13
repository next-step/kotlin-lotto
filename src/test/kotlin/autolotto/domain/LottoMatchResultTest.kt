package autolotto.domain

import autolotto.enums.prize.Prize
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMatchResultTest {
    @Test
    fun `보너스가 없고 매치가6일때  Prize 6을반환`() {
        val matchResult = LottoMatchResult(matchCount = 6, hasBonus = false)

        val prize = matchResult.toPrize()

        assertEquals(Prize.SIX, prize)
    }

    @Test
    fun `보너스가 있고 값이 5일때 Prize 보너스 반환`() {
        val matchResult = LottoMatchResult(matchCount = 5, hasBonus = true)

        val prize = matchResult.toPrize()

        assertEquals(Prize.BONUS, prize)
    }

    @Test
    fun `보너스가 없고 매칭 값이 5일때 Prize 5를 반환`() {
        val matchResult = LottoMatchResult(matchCount = 5, hasBonus = false)

        val prize = matchResult.toPrize()

        assertEquals(Prize.FIVE, prize)
    }
}
