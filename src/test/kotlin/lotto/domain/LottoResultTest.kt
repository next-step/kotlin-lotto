package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.data.Lotto
import lotto.domain.data.Rank

class LottoResultTest : StringSpec({
    "로또 등수와 결과 카운트 검증" {
        // Given
        val lottoResult = fakeLottoResult()

        // When
        val results = lottoResult.resultMap

        // Then
        results[Rank.FIRST] shouldBe 1
        results[Rank.SECOND] shouldBe 1
        results[Rank.THIRD] shouldBe 1
        results[Rank.FOURTH] shouldBe 1
    }

    "getTotalProfit() 결과 검증" {
        // given
        val lottoResult = fakeLottoResult()

        // when
        val profit = lottoResult.getTotalProfit()

        // then
        val totalMoney = Rank.entries.sumOf { it.prizeMoney }
        profit shouldBe totalMoney
    }
})

private fun fakeLottoResult(): LottoResult {
    val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    val myLottoList =
        listOf(
            // 3 matches
            Lotto(listOf(1, 2, 3, 400, 500, 600)),
            // 4 matches
            Lotto(listOf(1, 2, 3, 4, 500, 600)),
            // 5 matches
            Lotto(listOf(1, 2, 3, 4, 5, 600)),
            // 6 matches
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
        )
    val lottoResult = LottoResult(winningLotto, bonusLottoNumber = 8, myLottoList) // TODO - 보너스 숫자 관련 테스트 수정
    return lottoResult
}
