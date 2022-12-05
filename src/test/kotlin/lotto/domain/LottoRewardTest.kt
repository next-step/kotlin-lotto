package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoRewardTest : DescribeSpec({
    describe("로또 랭킹 테스트") {
        it("세개의 숫자가 일치할 경우 상금으로 5000원이 주어진다.") {
            val lottoReward = LottoReward.of(3)
            lottoReward.rewardPrice shouldBe Money(5000)
        }

        it("네개의 숫자가 일치할 경우 상금으로 50000원이 주어진다.") {
            val lottoReward = LottoReward.of(4)
            lottoReward.rewardPrice shouldBe Money(50000)
        }

        it("다섯개의 숫자가 일치할 경우 상금으로 1500000원이 주어진다.") {
            val lottoReward = LottoReward.of(5)
            lottoReward.rewardPrice shouldBe Money(1500000)
        }

        it("여섯개의 숫자가 일치할 경우 상금으로 2000000000원이 주어진다.") {
            val lottoReward = LottoReward.of(6)
            lottoReward.rewardPrice shouldBe Money(2000000000)
        }
    }
})
