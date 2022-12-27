package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RoundResultTest : DescribeSpec({
    describe("로또 회차 결과 테스트") {
        var countPerRank = Rank.values().associateWith { 0 }.toMutableMap()
        countPerRank[Rank.THIRD] = 1
        countPerRank[Rank.SECOND] = 2

        val roundResult = RoundResult(countPerRank)

        it("각 랭킬 별로 몇번 당첨되었는지 계산할 수 있다.") {
            roundResult.getCountOfRank(Rank.MISS) shouldBe 0
            roundResult.getCountOfRank(Rank.THIRD) shouldBe 1
            roundResult.getCountOfRank(Rank.SECOND) shouldBe 2
            roundResult.getCountOfRank(Rank.FIRST) shouldBe 0
        }

        it("해당 회차의 수익률을 계산할 수 있다.") {
            roundResult.calculateEarningRate() shouldBe 61500000 / 3000
        }
    }
})
