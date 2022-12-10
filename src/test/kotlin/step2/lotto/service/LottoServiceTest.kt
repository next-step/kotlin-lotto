package step2.lotto.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import step2.lotto.domain.BuyAmount
import step2.lotto.domain.PlayInfo
import step2.lotto.domain.WinningNumber

internal class LottoServiceTest : BehaviorSpec({
    val lottoService = LottoService(TestLottoGenerator())

    given("구매 금액과 당첨 번호가 주어지고") {
        val buyAmount = BuyAmount.of("1000")
        val winningNumber = WinningNumber.of(listOf(1, 2, 3, 4, 5, 6))
        val playInfo = PlayInfo.of(buyAmount, winningNumber)

        `when`("1등 로또를 발급하면") {
            val actual = lottoService.play(playInfo)
            then("1등 당첨 통계를 반환한다.") {
                actual.firstPlaceCount shouldBe 1
                actual.calculateProfitRate(buyAmount.value) shouldBe 2_000_000.0
            }
        }
    }
})
