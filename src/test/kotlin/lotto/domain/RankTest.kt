package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RankTest : DescribeSpec({
    describe("로또 랭킹 테스트") {
        listOf(
            Score(3, false) to 5000,
            Score(4, false) to 50000,
            Score(5, false) to 1500000,
            Score(5, true) to 30000000,
            Score(6, false) to 2000000000,
        ).forEach { (score: Score, rewardPrice: Int) ->
            it("$score 조건의 경우 상금으로 $rewardPrice 이 주어진다.") {
                Rank.of(score).rewardPrice shouldBe Money(rewardPrice)
            }
        }
    }
})
