package lotto.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BuyAmount
import lotto.domain.PurchaseItem
import lotto.domain.WinningNumber

internal class LottoServiceTest : BehaviorSpec({
    val lottoGenerator: LottoGenerator = TestLottoGenerator()
    val lottoService = LottoService()

    given("구매 금액과 1등 로또를 발급하고, 당첨 번호가 주어지고") {
        val buyAmount = BuyAmount.of("1000")
        val lottos = lottoGenerator.generate(buyAmount)
        val winningNumber = WinningNumber.of(listOf(1, 2, 3, 4, 5, 6))
        val purchaseItem = PurchaseItem.of(buyAmount, lottos)

        `when`("당첨 여부를 확인하면") {
            val actual = lottoService.play(purchaseItem, winningNumber)
            then("1등 당첨 통계를 반환한다.") {
                actual.firstPlaceCount shouldBe 1
                actual.calculateProfitRate(buyAmount.value) shouldBe 2_000_000.0
            }
        }
    }
})
