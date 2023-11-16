package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoesTest {
    @Test
    fun `Lottoes 객체는 올바른 개수의 Lotto 객체를 포함한다`() {
        val numberOfLottoes = 13
        val lottoes = Lottoes.buyLottoes(Amount(numberOfLottoes * Lotto.PRICE_PER_TICKET))
        assertEquals(numberOfLottoes, lottoes.count())
    }

    @Test
    fun `getPrizes 함수가 정상적으로 일치 등급을 반환해야 한다`() {
        val winningLotto = Lotto.get(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(10)
        val lottos = Lottoes(listOf(winningLotto))
        val expectedGrade = listOf(PrizeGrade.GRADE_1)

        val matches = lottos.getPrizes(winningLotto, bonusNumber)

        assertEquals(expectedGrade, matches)
    }
}
