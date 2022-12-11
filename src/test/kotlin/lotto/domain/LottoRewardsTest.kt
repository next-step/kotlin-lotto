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
            LottoReward.FAIL
        )
        val lottoRewards = LottoRewards(lottoRewardList)

        test("fun exchange():") {
            lottoRewards.exchange() shouldBe Cash(2_001_555_000)
        }

        test("fun toString():") {
            lottoRewards.toString() shouldBe """
            3개 일치 (5000원)- 1개
            4개 일치 (50000원)- 1개
            5개 일치 (1500000원)- 1개
            6개 일치 (2000000000원)- 1개
            """.trimIndent()
        }
    }
})
