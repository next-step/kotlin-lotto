package lotto.step2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step2.domain.LottoProfitManager
import lotto.step2.domain.RewardType

class LottoProfitManagerTest : FunSpec({
    test("로또 수익률을 계산한다.") {
        // given
        val givenLottos =
            listOf(
                LottoStub.get(matchCount = 0),
                LottoStub.get(matchCount = 1),
                LottoStub.get(matchCount = 2),
                LottoStub.get(matchCount = 3),
                LottoStub.get(matchCount = 4),
                LottoStub.get(matchCount = 5),
                LottoStub.get(matchCount = 6),
            )

        // when
        val result = LottoProfitManager.computeProfit(givenLottos)

        // then
        val winningAmountSum = RewardType.entries.sumOf { it.winningAmount }
        val totalPurchaseAmount = givenLottos.size * 1000

        result shouldBe (winningAmountSum.toDouble() / totalPurchaseAmount)
    }
})
