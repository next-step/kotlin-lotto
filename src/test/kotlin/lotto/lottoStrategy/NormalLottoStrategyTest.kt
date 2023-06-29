package lotto.lottoStrategy

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeLessThan
import lotto.domain.lottoStrategy.NormalLottoStrategy

internal class NormalLottoStrategyTest : BehaviorSpec({

    Given("NormalLottoStrategy") {
        val lottoStrategy = NormalLottoStrategy
        When("makeLottoNumbers()의 결과값은") {
            val actual = lottoStrategy.makeLottoNumbers()
            Then("정렬된 오름차순 배열을 가진 LottoNumbers이다.") {
                actual.lottoNumbers.windowed(2).forAll { (a, b) ->
                    a.number shouldBeLessThan b.number
                }
            }
        }
    }
})
