package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.data.Lotto
import lotto.domain.data.LottoWinPlace

class LottoResultTest : StringSpec({
    "getResults() 결과 검증" {
        // Given
        val lottoResult = fakeLottoResult()

        // When
        val results = lottoResult.resultMap

        // Then
        results[LottoWinPlace.FIRST] shouldBe 1
        results[LottoWinPlace.SECOND] shouldBe 1
        results[LottoWinPlace.THIRD] shouldBe 1
        results[LottoWinPlace.FOURTH] shouldBe 1
    }

    "getTotalProfit() 결과 검증" {
        // given
        val lottoResult = fakeLottoResult()

        // when
        val profit = lottoResult.getTotalProfit()

        // then
        val totalMoney = LottoWinPlace.entries.sumOf { it.prizeMoney }
        profit shouldBe totalMoney
    }
})

private fun fakeLottoResult(): LottoResult {
    val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    val myLottoList = listOf(
        Lotto(listOf(1, 2, 3, 400, 500, 600)), // 3 matches
        Lotto(listOf(1, 2, 3, 4, 500, 600)), // 4 matches
        Lotto(listOf(1, 2, 3, 4, 5, 600)), // 5 matches
        Lotto(listOf(1, 2, 3, 4, 5, 6)), // 6 matches
    )
    val lottoResult = LottoResult(winningLotto, myLottoList)
    return lottoResult
}
