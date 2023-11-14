package camp.nextstep.edu.step.step2.domain.result

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("로또 결과는")
class LottoResultTest : BehaviorSpec({

    Given("로또의 총 금액과, 매치 결과가 주어지면") {
        val totalPrice = 1000
        val matchResult = listOf(LottoMatch.of(matchCount = 6))

        When("로또 결과를 생성하면") {
            val lottoResult =
                LottoResult(lottoTotalPrice = totalPrice, lottoResults = matchResult)

            Then("로또 결과가 생성된다") {
                lottoResult shouldBe LottoResult(
                    lottoTotalPrice = 1000,
                    lottoResults = listOf(LottoMatch.of(matchCount = 6))
                )
            }
        }
    }

    Given("로또 결과 객체가 주어지고") {
        val totalPrice = 1000
        val matchResult = listOf(LottoMatch.of(matchCount = 6))

        val lottoResult = LottoResult(lottoTotalPrice = totalPrice, lottoResults = matchResult)

        When("로또 통계율 계산을 시도하면") {
            val result = lottoResult.calculateProfitRate()

            Then("로또 통계율이 계산된다") {
                result shouldBe 2000000.0
            }
        }
    }
})
