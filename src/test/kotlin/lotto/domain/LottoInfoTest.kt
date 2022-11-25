package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoInfoTest : BehaviorSpec({
    Given("매치 숫자 5이고 ") {
        When("보너스 볼이 맞다면 ") {
            val matchNumber = 5
            val isBonusNumberMatched = true
            val lottoInfo = LottoInfo.of(matchNumber, isBonusNumberMatched)
            Then("2등이다.") {
                lottoInfo shouldBe LottoInfo.FIVE_MATCH_WITH_BONUS_BALL
            }
        }

        When("보너스 볼이 맞지 않다면 ") {
            val matchNumber = 5
            val isBonusNumberMatched = false
            val lottoInfo = LottoInfo.of(matchNumber, isBonusNumberMatched)
            Then("3등이다.") {
                lottoInfo shouldBe LottoInfo.FIVE_MATCH
            }
        }
    }
})
