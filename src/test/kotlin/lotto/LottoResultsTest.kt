package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoResultsTest : FreeSpec({
    "당첨 결과 금액을 모두 합산한다" {
        val lottoResults = LottoResults(listOf(LottoRank.FIRST, LottoRank.SECOND))

        val actual = lottoResults.calculateTotalPrizeAmount()

        actual shouldBe LottoRank.FIRST.prizeAmount + LottoRank.SECOND.prizeAmount
    }
})
