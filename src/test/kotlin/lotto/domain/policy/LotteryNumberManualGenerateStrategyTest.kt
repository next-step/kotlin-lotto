package lotto.domain.policy

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.vo.LotteryNumbers
import lotto.domain.vo.generateList

internal class LotteryNumberManualGenerateStrategyTest : FreeSpec({
    "수동으로 입력한 당첨 번호로 생성할 수 있다" {
        val list = generateList(1, 6)
        val lotteryNumbers = LotteryNumbers(lotteryNumbers = list)
        val lotteryNumberManualGenerateStrategy = LotteryNumberManualGenerateStrategy(lotteryNumbers = lotteryNumbers)
        val generatedManualLotteryNumbers = lotteryNumberManualGenerateStrategy.generate()
        lotteryNumbers shouldBe generatedManualLotteryNumbers
    }
})
