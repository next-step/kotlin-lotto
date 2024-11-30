package lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoResultsTest : FreeSpec({
    "당첨 결과 금액을 모두 합산한다" {
        val lottoResults = LottoResults(listOf(LottoRank.FIRST, LottoRank.SECOND))

        val actual = lottoResults.calculateTotalPrizeAmount()

        actual shouldBe LottoRank.FIRST.prizeAmount + LottoRank.SECOND.prizeAmount
    }

    "당첨된 로또 개수를 반환한다" {
        val lottoResults =
            LottoResults(
                listOf(
                    LottoRank.FIRST,
                    LottoRank.FIRST,
                    LottoRank.FIRST,
                    LottoRank.SECOND,
                    LottoRank.SECOND,
                    LottoRank.THIRD,
                ),
            )

        assertSoftly {
            lottoResults.getWinningLottoCountBy(LottoRank.FIRST) shouldBe 3
            lottoResults.getWinningLottoCountBy(LottoRank.SECOND) shouldBe 2
            lottoResults.getWinningLottoCountBy(LottoRank.THIRD) shouldBe 1
            lottoResults.getWinningLottoCountBy(LottoRank.FORTH) shouldBe 0
        }
    }
})
