package lotto.auto.vo

import io.kotest.core.spec.style.BehaviorSpec

internal class LottoScoreTest : BehaviorSpec({

    given("일치하는 숫자가") {

        `when`("1개인 경우") {
            val result = LottoScore.matchCountOf(1)

            then("결과는 꽝") {
                result shouldBe LottoScore.BANG
            }
        }
    }
})
