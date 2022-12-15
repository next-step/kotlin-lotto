package lotto.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BuyAmount
import lotto.domain.MatchResult.FIRST_PLACE
import lotto.domain.PurchaseItem
import lotto.domain.WinningNumber

internal class LottoServiceTest : BehaviorSpec({
    val lottoGenerator: LottoGenerator = TestLottoGenerator()
    val lottoService = LottoService()

    given("구매 금액과 1등 당첨 번호와 1등 로또가 주어지고") {
        val buyAmount = BuyAmount.of("1000")
        val lottos = lottoGenerator.generate(buyAmount)
        val winningNumber = WinningNumber.of(setOf(1, 2, 3, 4, 5, 6), 7)
        val purchaseItem = PurchaseItem.of(buyAmount, lottos)

        `when`("당첨 여부를 확인하면") {
            val actual = lottoService.play(purchaseItem, winningNumber)
            then("1등 당첨 통계를 반환한다.") {
                actual[FIRST_PLACE] shouldBe 1
                actual.profitRate shouldBe 2_000_000.0
            }
        }
    }
})
