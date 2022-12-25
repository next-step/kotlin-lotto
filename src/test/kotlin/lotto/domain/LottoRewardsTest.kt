package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see LottoRewards
 */
class LottoRewardsTest : FunSpec({

    context("LottoReward") {
        val lottoRewardList = listOf(
            LottoReward.FIRST,
            LottoReward.SECOND,
            LottoReward.THIRD,
            LottoReward.FIRTH,
            LottoReward.FIFTH,
            LottoReward.FAIL
        )
        val lottoRewards = LottoRewards(lottoRewardList)

        test("fun exchange():") {
            val lottoRewardCash = lottoRewards.exchange()
            lottoRewardCash.toString() shouldBe "2031555000"
        }

        test("fun getByGroup():") {
            with(lottoRewards.getByGroup()) {
                this[LottoReward.FIRST] shouldBe 1
                this[LottoReward.SECOND] shouldBe 1
                this[LottoReward.THIRD] shouldBe 1
                this[LottoReward.FIRTH] shouldBe 1
                this[LottoReward.FAIL] shouldBe 1
            }
        }
    }
})
