package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoesTest {
    @Test
    fun `Lottoes 객체는 올바른 개수의 Lotto 객체를 포함한다`() {
        val numberOfLottoes = 13
        val lottoes = Lottoes.generateLottoes(numberOfLottoes)
        assertEquals(numberOfLottoes, lottoes.count())
    }

    @Test
    fun `countMatches 함수가 정상적으로 일치 횟수를 반환해야 한다`() {
        val winningLotto = Lotto.get(listOf(1, 2, 3, 4, 5, 6))
        val lottos = Lottoes(listOf(winningLotto))
        val expectedMatches = listOf(6)

        val matches = lottos.countMatches(winningLotto)

        assertEquals(expectedMatches, matches)
    }
}
