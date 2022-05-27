package lotto.auto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoTest : BehaviorSpec({

    given("주어진 로또가") {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        `when`("1개 맞을 경우") {
            val correctOneLotto = Lotto(listOf(1, 7, 8, 9, 10, 11))
            val result = lotto.match(correctOneLotto)

            then("꽝") {
                result shouldBe 1
            }
        }
    }
})
