package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoRankTest : DescribeSpec({
    describe("LottoRank 조회") {
        context("당첨개수에 따라 일치하는 LottoRank 제공") {
            data class RankExpected(val matchingCount: Int, val expected: LottoRank)
            withData(
                RankExpected(0, LottoRank.MISS),
                RankExpected(1, LottoRank.MISS),
                RankExpected(2, LottoRank.MISS),
                RankExpected(3, LottoRank.FIRST),
                RankExpected(4, LottoRank.SECOND),
                RankExpected(5, LottoRank.THIRD),
                RankExpected(6, LottoRank.FOURTH)
            ) { (matchingCount, expected) ->
                LottoRank.from(matchingCount) shouldBe expected
            }
        }
    }

})
