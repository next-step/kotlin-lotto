package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameResultTest {

    @Test
    fun `수익률 계산이 올바르게 수행된다`() {
        val lottoes = Lottoes(
            listOf(
                Lotto(LottoNumber.listOf(1, 2, 3, 10, 20, 30).let(::LottoNumbers)),
                Lotto(listOf(1, 2, 3, 4, 20, 30).map(::LottoNumber).let(::LottoNumbers)),
                Lotto(listOf(40, 41, 42, 43, 44, 45).map(::LottoNumber).let(::LottoNumbers))
            )
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::LottoNumbers))
        val purchaseAmount = 3000
        val bonusNumber = LottoNumber(9)

        val result = LottoGameResult.getResult(lottoes, winningLotto, bonusNumber)
        val expectedEarningsRate = (5000 + 50000).toDouble() / purchaseAmount

        assertEquals(expectedEarningsRate, result.earningsRate)
    }

    @Test
    fun `올바른 로또 번호 일치 횟수를 반환한다`() {
        val lottoes = Lottoes(
            listOf(
                Lotto(listOf(1, 2, 3, 10, 20, 30).map(::LottoNumber).let(::LottoNumbers)),
                Lotto(listOf(1, 2, 3, 4, 20, 30).map(::LottoNumber).let(::LottoNumbers)),
                Lotto(listOf(40, 41, 42, 43, 44, 45).map(::LottoNumber).let(::LottoNumbers))
            )
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::LottoNumbers))
        val bonusNumber = LottoNumber(9)

        val result = LottoGameResult.getResult(lottoes, winningLotto, bonusNumber)
        val expectedStatistics = mapOf(
            PrizeGrade.GRADE_5 to 1,
            PrizeGrade.GRADE_4 to 1,
            PrizeGrade.GRADE_3 to 0,
            PrizeGrade.GRADE_2 to 0,
            PrizeGrade.GRADE_1 to 0
        )

        assertEquals(expectedStatistics, result.statistics)
    }
}
