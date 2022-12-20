package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RankTest : DescribeSpec({
    describe("로또 랭킹 테스트") {
        it("세개의 숫자가 일치할 경우 상금으로 5000원이 주어진다.") {
            val condition = 3 to false
            val rank = Rank.of(condition)

            rank.rewardPrice shouldBe Money(5000)
        }

        it("네개의 숫자가 일치할 경우 상금으로 50000원이 주어진다.") {
            val condition = 4 to false
            val rank = Rank.of(condition)

            rank.rewardPrice shouldBe Money(50000)
        }

        it("다섯개의 숫자가 일치할 경우 상금으로 1500000원이 주어진다.") {
            val condition = 5 to false
            val rank = Rank.of(condition)

            rank.rewardPrice shouldBe Money(1500000)
        }

        it("다섯개의 숫자와 보너스 번호가 일치할 경우 상금으로 30000000원이 주어진다.") {
            val condition = 5 to true
            val rank = Rank.of(condition)

            rank.rewardPrice shouldBe Money(30000000)
        }

        it("여섯개의 숫자가 일치할 경우 상금으로 2000000000원이 주어진다.") {
            val condition = 6 to false
            val rank = Rank.of(condition)

            rank.rewardPrice shouldBe Money(2000000000)
        }
    }
})
