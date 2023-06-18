package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoWinningStatTest : DescribeSpec({

    describe("LottoWinningStat method") {
        context("로또 구매 금액과, 총 당첨 금액을 넣으면") {
            it("수익률을 소수점 둘째자리까지 제공") {
                LottoWinningStat.of(
                    mapOf(
                        Pair(LottoRank.FIRST, 0),
                        Pair(LottoRank.SECOND, 0),
                        Pair(LottoRank.THIRD, 0),
                        Pair(LottoRank.FOURTH, 0),
                        Pair(LottoRank.FIFTH, 1),
                        Pair(LottoRank.MISS, 0),
                    )
                ).performance(1000) shouldBe "5.00"
            }
        }
    }
})
