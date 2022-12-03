package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoPrizeTest : FreeSpec({

    "totalRate" - {

        "로또 구매에 쓴 금액에 비해 로또 당첨 수익률이 얼마인지 반환한다." {
            val lottoPrize = LottoPrize(listOf(5000, 0, 0, 0, 0))
            val rate = lottoPrize.totalRate(5000)

            rate shouldBe 1.0
        }
    }
})
