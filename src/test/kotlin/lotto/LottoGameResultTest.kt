package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameResultTest : FunSpec({
    val lottoGameResult = LottoGameResult(totalPrice = 3000, rewards = listOf(LottoReward.FOURTH))

    test("로또 게임의 수익률은 `수익금 / 원금` 으로 계산된다.") {
        val expected = LottoReward.FOURTH.reward.toDouble() / 3000
        lottoGameResult.calculatePerformance() shouldBe expected
    }
})
