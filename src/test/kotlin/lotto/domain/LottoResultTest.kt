package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({
    "구입 금액 대비 수익률을 계산한다." {
        // given
        val buyingPrice = LottoBuyingPrice(10_000)
        val matchCountByRank = mapOf(
            LottoRank.THREE to 1,
        )

        val lottoResult = LottoResult(matchCountByRank)

        // when
        val earningRate = lottoResult.calculateEarningRate(buyingPrice)

        // then
        earningRate shouldBe 0.5
    }
},)
