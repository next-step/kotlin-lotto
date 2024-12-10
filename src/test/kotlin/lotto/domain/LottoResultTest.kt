package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainOnly
import io.kotest.matchers.shouldBe

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

    "일치하는 로또 번호가 없다면 resultMap 의 값들은 0 이다" {
        // Given
        val lottoResultNoMatch = LottoResult(
            winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            bonusLottoNumber = LottoNumber(7),
            myLottoList = listOf(
                Lotto(listOf(8, 9, 10, 11, 12, 13).map { LottoNumber(it) })
            )
        )
        //when & then
        val results = lottoResultNoMatch.resultMap
        results.values.shouldContainOnly(0)
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
    val lottoResult =
        LottoResult(
            winningLotto = winningLotto,
            bonusLottoNumber = LottoNumber(800),
            myLottoList = myLottoList,
        )
    return lottoResult
}
