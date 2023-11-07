package lotto.domain

import lotto.domain.JackpotLevel.FIVE_MATCH
import lotto.domain.JackpotLevel.FOUR_MATCH
import lotto.domain.JackpotLevel.SIX_MATCH
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRoiManagerTest {

    @Test
    fun `수익률 계산식에 맞춰 정확한 수익률이 나와야 한다`() {
        val roi = LottoRoiManager.calculateROI(TOTAL_INCOME, INVEST_MONEY)
        assertEquals(0.35, roi, 0.01)
    }

    @Test
    fun `총 수익이 정확하게 반환된다`() {
        val findJackpotLotto: List<JackpotLevel> = listOf(SIX_MATCH, FIVE_MATCH, FOUR_MATCH)
        val totalIncome = LottoRoiManager.getTotalIncome(findJackpotLotto)
        assertEquals(2001550000, totalIncome)
    }

    companion object {
        private const val INVEST_MONEY = 14000
        private const val TOTAL_INCOME = 5000
    }
}
