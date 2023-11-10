package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoGameResult
import lotto.domain.LottoReward

class LottoGameResultTest : FunSpec({
    test("로또 게임의 수익률은 `수익금 / 원금` 으로 계산된다.") {
        val lottoGameResult = LottoGameResult(totalPrice = 3000, rewards = listOf(LottoReward.FOURTH))
        val expected = LottoReward.FOURTH.reward.toDouble() / 3000
        lottoGameResult.calculatePerformance() shouldBe expected
    }

    test("로또 게임으로부터 각 등수가 몇명인지 알 수 있다.") {
        val lottoGameResult = LottoGameResult(
            totalPrice = 3000,
            rewards = listOf(LottoReward.FIRST, LottoReward.SECOND)
        )
        lottoGameResult.getRewardCount(LottoReward.FIRST) shouldBe 1
        lottoGameResult.getRewardCount(LottoReward.SECOND) shouldBe 1
        lottoGameResult.getRewardCount(LottoReward.THIRD) shouldBe 0
        lottoGameResult.getRewardCount(LottoReward.FOURTH) shouldBe 0
    }

    test("로또 게임결과의 상태를 출력하면 등수별 인원수, 총 수익률이 출력된다.") {
        val lottoGameResult = LottoGameResult(
            totalPrice = 3000,
            rewards = listOf(LottoReward.FIRST, LottoReward.SECOND)
        )
        lottoGameResult.toString() shouldBe """
            3개 일치 (5000원) - 0개
            4개 일치 (50000원) - 0개
            5개 일치 (1500000원) - 1개
            6개 일치 (2000000000원) - 1개
            총 수익률은 667,166.67입니다.
            """.trimIndent()
    }
})
