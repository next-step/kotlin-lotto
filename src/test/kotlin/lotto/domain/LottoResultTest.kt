package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.data.Lotto
import lotto.domain.data.LottoNumber
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
        results[Rank.FIFTH] shouldBe 1
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
    val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
    val myLottoList =
        listOf(
            // 3 matches
            Lotto(listOf(1, 2, 3, 400, 500, 600).map { LottoNumber(it) }),
            // 4 matches
            Lotto(listOf(1, 2, 3, 4, 500, 600).map { LottoNumber(it) }),
            // 5 matches
            Lotto(listOf(1, 2, 3, 4, 5, 600).map { LottoNumber(it) }),
            // 5 matches and bonus
            Lotto(listOf(1, 2, 3, 4, 5, 800).map { LottoNumber(it) }),
            // 6 matches
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
        )
    val lottoResult = LottoResult(
        winningLotto = winningLotto,
        bonusLottoNumber = LottoNumber(800),
        myLottoList = myLottoList
    )
    return lottoResult
}
