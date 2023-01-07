package lottery.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.RuntimeException
import kotlin.math.floor

class ExchangeServiceSpec : BehaviorSpec({

    Given("교환 서비스는") {
        val exchangeService = ExchangeService()
        val lottoPrice = ExchangeService.LOTTO_PRICE

        When("로또 구입 금액을 받으면") {
            val purchasingAmount = 5000L
            val quantity = exchangeService.calculateQuantity(purchasingAmount)

            Then("구입한 로또의 수량을 반환한다") {
                quantity shouldBe floor(purchasingAmount.toDouble() / lottoPrice).toInt()
            }
        }

        When("로또 구입 금액이 로또 금액보다 작으면") {
            val purchasingAmount = 900L

            Then("예외를 던진다") {
                shouldThrow<RuntimeException> {
                    exchangeService.calculateQuantity(purchasingAmount)
                }
            }
        }
    }
})
