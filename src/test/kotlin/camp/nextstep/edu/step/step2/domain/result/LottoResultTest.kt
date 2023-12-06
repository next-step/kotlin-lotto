package camp.nextstep.edu.step.step2.domain.result

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("로또 결과는")
class LottoResultTest : BehaviorSpec({

    Given("로또의 총 금액과, 매치 결과가 주어지면") {
        val totalPrice = 1000
        val matchResult = listOf(LottoMatch.of(matchCount = 6, bonusMatch = 0))

        When("로또 결과를 생성하면") {
            val lottoResult =
                LottoResult(lottoTotalPrice = totalPrice, lottoResults = matchResult)

            Then("로또 결과가 생성된다") {
                lottoResult shouldBe LottoResult(
                    lottoTotalPrice = 1000,
                    lottoResults = listOf(LottoMatch.of(matchCount = 6, bonusMatch = 0))
                )
            }
        }
    }

    Given("로또 결과 도메인이 주어지고") {
        val totalPrice = 1000
        val matchResult = listOf(LottoMatch.of(matchCount = 1, bonusMatch = 0))
        val lottoResult = LottoResult(lottoTotalPrice = totalPrice, lottoResults = matchResult)

        When("로또 결과 전달을 위한 Dto를 생성하면") {
            val lottoResultDto = lottoResult.calculateResultAndReturnDto()

            Then("로또 결과 Dto가 반환된다") {
                lottoResultDto.matchResponse.size shouldBe 6
                lottoResultDto.lottoProfitRate shouldBe 0.0
            }
        }
    }

})

