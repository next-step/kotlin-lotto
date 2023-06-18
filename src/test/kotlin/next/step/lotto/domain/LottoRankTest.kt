package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoRankTest : DescribeSpec({
    describe("LottoRank 조회") {

        context("당첨개수와 보너스 매칭에 따라 일치하는 LottoRank 제공") {
            data class RankBonusExpected(val matchingCount: Int, val bonusMatch: Boolean, val expected: LottoRank)
            withData(
                RankBonusExpected(0, true, LottoRank.MISS), RankBonusExpected(0, false, LottoRank.MISS),
                RankBonusExpected(1, true, LottoRank.MISS), RankBonusExpected(1, false, LottoRank.MISS),
                RankBonusExpected(2, true, LottoRank.MISS), RankBonusExpected(2, false, LottoRank.MISS),
                RankBonusExpected(3, true, LottoRank.FIFTH), RankBonusExpected(3, false, LottoRank.FIFTH),
                RankBonusExpected(4, true, LottoRank.FOURTH), RankBonusExpected(4, false, LottoRank.FOURTH),
                RankBonusExpected(5, false, LottoRank.THIRD),
                RankBonusExpected(5, true, LottoRank.SECOND),
                RankBonusExpected(6, false, LottoRank.FIRST), RankBonusExpected(6, true, LottoRank.FIRST)
            ) { (matchingCount, bonusMatch, expected) ->
                LottoRank.from(matchingCount, bonusMatch) shouldBe expected
            }
        }
    }

})
