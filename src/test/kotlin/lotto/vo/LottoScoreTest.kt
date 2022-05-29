package lotto.vo

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoScoreTest : BehaviorSpec({

    given("일치하는 숫자가") {

        `when`("1개인 경우") {
            val result = LotteryRank.of(1)

            then("결과는 꽝") {
                result shouldBe LotteryRank.NONE
            }
        }

        `when`("2개인 경우") {
            val result = LotteryRank.of(2)

            then("결과는 꽝") {
                result shouldBe LotteryRank.NONE
            }
        }

        `when`("3개인 경우") {
            val result = LotteryRank.of(3)

            then("결과는 4등") {
                result shouldBe LotteryRank.FOUR_PLACE
            }
        }

        `when`("4개인 경우") {
            val result = LotteryRank.of(4)

            then("결과는 3등") {
                result shouldBe LotteryRank.THIRD_PLACE
            }
        }

        `when`("5개인 경우") {
            val result = LotteryRank.of(5)

            then("결과는 2등") {
                result shouldBe LotteryRank.TWO_PLACE
            }
        }

        `when`("6개인 경우") {
            val result = LotteryRank.of(6)

            then("결과는 1등") {
                result shouldBe LotteryRank.ONE_PLACE
            }
        }
    }
})
