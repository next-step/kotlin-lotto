package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ScoreTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3,11,8,9;7;0.5", "1,2,3,4,8,9;7;5"], delimiter = ';')
    internal fun `동일한 개수에 등수가 결정되고 그에 따른 수익률이 계산된다`(winningNums: String, bonus: Int, result: Float) {
        val winningTicket = WinningTicket(Lotto(winningNums.split(",").map { LottoNumber(it.toInt()) }), bonus)
        val testLotto = Tickets(1, listOf(), TestNumGenerator())
        val score = winningTicket.score(testLotto)

        score.calculateRateOfReturn(10000) shouldBe result
    }
}