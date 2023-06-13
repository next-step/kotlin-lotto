package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoWinningStatTest : DescribeSpec({
    
    describe("LottoWinningStat method") {
        context("로또 구매 금액과, 총 당첨 금액을 넣으면") {
            it("수익률을 소수점 둘째자리까지 제공") {
                LottoWinningStat.of(
                    mapOf(
                        Pair(LottoWinningCount.SIX, 0),
                        Pair(LottoWinningCount.FIVE, 1),
                        Pair(LottoWinningCount.FOUR, 1),
                        Pair(LottoWinningCount.THREE, 1),
                        Pair(LottoWinningCount.NONE, 3),
                    )
                ).performance(1000) shouldBe "0.15"
            }
        }
    }
})
