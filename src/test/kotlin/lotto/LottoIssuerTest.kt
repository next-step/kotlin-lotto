package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoIssuerTest : BehaviorSpec({

    Given("로또 발급기에") {
        val lottoIssuer = LottoIssuer

        When("14,000원을 넣으면") {
            val price = Money(14_000)

            Then("14개의 로또를 발급한다") {
                val lottoNumbers = lottoIssuer.issue(price, manualLottoNumbers)
                lottoNumbers.size shouldBe 14
            }
        }

        When("13,333원을 넣으면") {
            val price = Money(13_333)

            Then("13개의 로또를 발급한다") {
                val lottoNumbers = lottoIssuer.issue(price, manualLottoNumbers)
                lottoNumbers.size shouldBe 13
            }
        }
    }
})
