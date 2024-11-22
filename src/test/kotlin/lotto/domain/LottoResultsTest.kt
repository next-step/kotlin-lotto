package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.vo.LottoResult

class LottoResultsTest : StringSpec({

    val results =
        LottoResults(listOf(LottoResult(rank = LottoRank.FIRST, 2), LottoResult(rank = LottoRank.NONE, 1)))

    "로또 결과는 이익율를 조회할 수 있다." {
        val profitRate = results.calculateProfitRate()
        val purchaseAmount = 3 * LottoPurchaseCount.PRICE_PER_LOTTO
        val profit = LottoRank.FIRST.reward * 2
        val expected = (profit / purchaseAmount).toDouble()

        profitRate shouldBe expected
    }

    "로또 결과는 이익률이 1보다 크면 이익이다." {
        results.isProfit() shouldBe true
    }

    "로또 결과는 당첨된 로또만 조회할 수 있다." {
        val winResults = results.filterWinResults()
        winResults.forEach { it.rank.isWin() shouldBe true }
    }
})
