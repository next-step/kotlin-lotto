package lottery.service

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import kotlin.math.floor

class LottoServiceSpec : BehaviorSpec({

    Given("로또 발행 서비스는") {
        val lottoService = LottoService(ExchangeService())
        val lottoPrice = ExchangeService.LOTTO_PRICE

        When("로또 구입 금액을 받으면") {
            val purchasingAmount = 10000L
            val lottos = lottoService.issue(purchasingAmount)

            Then("구입 금액만큼 로또를 발급한다") {
                lottos shouldHaveSize floor(purchasingAmount.toDouble() / lottoPrice).toInt()
            }
        }
    }

})
