package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import lotto.domain.LottoNumber

internal class LottoNumberTest : BehaviorSpec({

    Given("LottoNumber") {
        When("1~45 사이의 숫자가 아닌 경우") {
            val testCases = listOf(0, 46, -1)
            Then("IllegalArgumentException 발생") {
                testCases.forAll { testCase ->
                    shouldThrow<IllegalArgumentException> { LottoNumber(testCase) }
                }
            }
        }
    }
})
