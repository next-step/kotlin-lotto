package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoWinningStatTest : DescribeSpec({
    describe("LottoWinningStat method") {
        context("만들어진 당첨 통계를 기준으로") {
            it("총 당첨금액 계산") {
                LottoWinningStat.of(
                    mapOf(
                        Pair(LottoWinningCount.SIX, 0),
                        Pair(LottoWinningCount.FIVE, 1),
                        Pair(LottoWinningCount.FOUR, 1),
                        Pair(LottoWinningCount.THREE, 1),
                        Pair(LottoWinningCount.NONE, 3),
                    )
                ).totalWinnings() shouldBe 1555000
            }
        }
    }

})
