package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lottery.RankReward.Companion.fromMatchedNumberCount
import lottery.RankReward.RANK_1

class RankRewardTest : StringSpec({
    "매칭 숫자 카운트에 따라 랭크를 반환한다" {
        fromMatchedNumberCount(6) shouldBe RANK_1
    }
})
