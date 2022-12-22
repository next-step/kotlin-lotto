package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoWinningAmountTest : DescribeSpec({
    val winningAmountList = mapOf(
        LottoReward.MATCH_THREE.rewardPrice to 2,
        LottoReward.MATCH_FOUR.rewardPrice to 1,
        LottoReward.MATCH_FIVE.rewardPrice to 1,
        LottoReward.MATCH_SIX.rewardPrice to 0
    )
    val lottoWinningAmount = LottoWinningAmount(winningAmountList)

    it("로또 당첨 금액 중 맞춘 갯수 별로 금액을 조회할 수 있다.") {
        lottoWinningAmount.amountOf(3) shouldBe Money(10000)
        lottoWinningAmount.amountOf(4) shouldBe Money(50000)
        lottoWinningAmount.amountOf(5) shouldBe Money(1500000)
        lottoWinningAmount.amountOf(6) shouldBe Money.ZERO
    }

    it("로또 당첨 금액의 총 합을 조회할 수 있다.") {
        lottoWinningAmount.sum() shouldBe Money(1560000)
    }
})
