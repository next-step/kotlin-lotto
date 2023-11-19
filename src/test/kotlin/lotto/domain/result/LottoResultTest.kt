package lotto.domain.result

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.purchase.LottoBuyingPrice
import lotto.domain.purchase.LottoBuyingPriceResult

class LottoResultTest : StringSpec({

    "구입 금액 대비 수익률을 계산한다." {
        // given
        val buyingPriceResult = LottoBuyingPrice.createResult(10_000)
        val buyingPrice = buyingPriceResult as LottoBuyingPriceResult.Success
        val matchCountByRank = mapOf(
            LottoRank.FIFTH to 1
        )

        val lottoResult = LottoPlayResult(matchCountByRank)

        // when
        val earningRate = lottoResult.calculateEarningRate(buyingPrice.data)

        // then
        earningRate shouldBe 0.5
    }
})
