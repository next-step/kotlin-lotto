package lotto.auto.vo

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoScoreTest : BehaviorSpec({

    given("일치하는 숫자가") {

        `when`("1개인 경우") {
            val result = LottoScore.matchCountOf(1)

            then("결과는 꽝") {
                result shouldBe LottoScore.BANG
            }
        }

        `when`("2개인 경우") {
            val result = LottoScore.matchCountOf(2)

            then("결과는 꽝") {
                result shouldBe LottoScore.BANG
            }
        }

        `when`("3개인 경우") {
            val result = LottoScore.matchCountOf(3)

            then("결과는 4등") {
                result shouldBe LottoScore.FOUR_PLACE
            }
        }

        `when`("4개인 경우") {
            val result = LottoScore.matchCountOf(4)

            then("결과는 3등") {
                result shouldBe LottoScore.THIRD_PLACE
            }
        }

        `when`("5개인 경우") {
            val result = LottoScore.matchCountOf(5)

            then("결과는 2등") {
                result shouldBe LottoScore.TWO_PLACE
            }
        }

        `when`("6개인 경우") {
            val result = LottoScore.matchCountOf(6)

            then("결과는 1등") {
                result shouldBe LottoScore.ONE_PLACE
            }
        }
    }
})
