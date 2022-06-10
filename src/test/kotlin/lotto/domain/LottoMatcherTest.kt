package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoMatcherTest {

    // 같이? 따로 분리?
    @Test
    fun `로또 당첨 결과기는 당첨 개수와 당첨금액을 반환한다`() {
        val lottoTickets = LottoTickets(
            3,
            listOf(
                LottoTicket(listOf(1, 2, 33, 34, 35, 36)),
                LottoTicket(listOf(1, 2, 3, 34, 35, 36)),
                LottoTicket(listOf(1, 2, 3, 4, 35, 36))
            )
        )
        val winningNumbers = WinningNumber(listOf(1, 2, 3, 4, 5, 6))
        val lottoMatchResult = LottoMatcher().matchResult(lottoTickets, winningNumbers)
        val matchResult = lottoMatchResult.matchResult
        val earnedMoney = lottoMatchResult.earnedMoney
        assertEquals(1, matchResult[WinningInfo.THREE])
        assertEquals(1, matchResult[WinningInfo.FOUR])
        assertEquals(0, matchResult[WinningInfo.FIVE])
        assertEquals(0, matchResult[WinningInfo.SIX])
        assertEquals(55000L, earnedMoney.money)
    }

    @Test
    fun `로또 당첨 결과기는 수익률 계산을 할 수 있다`() {
        val paidMoney = 14000L
        val earnedMoney = 5000L
        val earnedRate = LottoMatcher().calculateEarnedRate(EarnedMoney(earnedMoney), paidMoney)
        assertEquals(0.35714287f, earnedRate.rate)
    }
}
