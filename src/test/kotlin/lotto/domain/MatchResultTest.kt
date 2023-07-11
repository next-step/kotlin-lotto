package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MatchResultTest {

    @Test
    fun `당첨금액을 구입금액으로 나눈 수익률을 반환한다`() {
        val ranks = listOf(Rank.FIFTH)
        val matchResult = MatchResult(ranks)

        matchResult.rateOfReturn(14000) shouldBe 0.35.toBigDecimal()
    }

    @Test
    fun `당첨 결과가 없는 경우 수익률이 0이다`() {
        val matchResult = MatchResult()

        matchResult.rateOfReturn(1000) shouldBe 0.00.toBigDecimal().setScale(2)
    }

    @Test
    fun `당첨 결과가 포함한 match 수를 반환한다`() {
        val ranks = listOf(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH)
        val matchResult = MatchResult(ranks)

        matchResult.countOf(Rank.FIFTH) shouldBe 2
        matchResult.countOf(Rank.FOURTH) shouldBe 1
    }
}
