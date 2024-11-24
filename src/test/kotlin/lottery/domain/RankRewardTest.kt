package lottery.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lottery.domain.RankReward.Companion.fromMatchedNumberCount
import lottery.domain.RankReward.RANK_1

class RankRewardTest : StringSpec({
    "매칭 숫자 카운트에 따라 랭크를 반환한다" {
        fromMatchedNumberCount(6) shouldBe RANK_1
    }
})
