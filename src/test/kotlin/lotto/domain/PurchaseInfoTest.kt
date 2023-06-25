package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.test.FakeGenerator

class PurchaseInfoTest : BehaviorSpec({
    given("10000원을 지불한다") {
        val paidPrice = 10000

        `when`("0개의 수동 로또를 전달한다") {
            val manualLottos = FakeGenerator.lottoNumbersOfLottos(0)
            then("10개의 자동 로또가 생성된다.") {
                val purchaseInfo = PurchaseInfo(paidPrice, manualLottos)
                purchaseInfo.autoLottoCount() shouldBe 10
            }
        }

        `when`("2개의 수동 로또를 전달한다") {
            val manualLottos = FakeGenerator.lottoNumbersOfLottos(2)
            then("8개의 자동 로또가 생성된다.") {
                val purchaseInfo = PurchaseInfo(paidPrice, manualLottos)
                purchaseInfo.autoLottoCount() shouldBe 8
            }
        }

        `when`("10개의 수동 로또를 전달한다") {
            val manualLottos = FakeGenerator.lottoNumbersOfLottos(2)
            then("0개의 자동 로또가 생성된다.") {
                val purchaseInfo = PurchaseInfo(paidPrice, manualLottos)
                purchaseInfo.autoLottoCount() shouldBe 8
            }
        }

        `when`("100개의 수동 로또를 전달한다") {
            val manualLottos = FakeGenerator.lottoNumbersOfLottos(100)
            then("에러가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    PurchaseInfo(paidPrice, manualLottos)
                }
            }
        }
    }
})
