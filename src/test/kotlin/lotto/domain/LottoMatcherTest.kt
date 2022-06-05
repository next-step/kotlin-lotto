package lotto.domain

import lotto.constant.WinningInfo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMatcherTest {

    @Test
    fun `로또 당첨 결과기는 당첨 수에 따른 실제 당첨 개수 정보를 알 수 있다`() {
        val lottoTickets = LottoTickets(3, listOf(
            LottoTicket(listOf(1,2,33,34,35,36)),
            LottoTicket(listOf(1,2,3,34,35,36)),
            LottoTicket(listOf(1,2,3,4,35,36))
        ))
        val winningNumbers = WinningNumber(listOf(1,2,3,4,5,6))
        val lottoMatchResult = LottoMatcher().matchResult(lottoTickets, winningNumbers)
        val matchResultMap = lottoMatchResult.matchResult
        assertEquals(1, matchResultMap[WinningInfo.THREE])
        assertEquals(1, matchResultMap[WinningInfo.FOUR])
        assertEquals(0, matchResultMap[WinningInfo.FIVE])
        assertEquals(0, matchResultMap[WinningInfo.SIX])
    }

    @Test
    fun `로또 당첨 결과기는 수익률 계산을 할 수 있다`() {
        val paidMoney = 14000
        val matchResult = LottoMatchResult(mapOf(
            WinningInfo.THREE to 1,
            WinningInfo.FOUR to 0,
            WinningInfo.FIVE to 0,
            WinningInfo.SIX to 0,
        ))
        val earnedRate = LottoMatcher().getEarnedRate(paidMoney, matchResult)
        assertEquals("0.35", earnedRate.earnedRate)
    }
}