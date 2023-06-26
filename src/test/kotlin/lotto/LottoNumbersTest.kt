package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers

internal class LottoNumbersTest : BehaviorSpec({

    Given("LottoNumbers") {
        When("of(inputNumbers: String)이 쉼표로 구분된 숫자를 입력받으면") {
            val inputNumbers = listOf(
                "1,2,3" to listOf(1, 2, 3),
                "1,2,3,4,5,6" to listOf(1, 2, 3, 4, 5, 6),
                "123,456" to listOf(123, 456)
            )
            Then("그 수들로 이루어진 LottoNumbers를 반환한다.") {
                inputNumbers.forAll { testCase ->
                    LottoNumbers.of(testCase.first).numbers shouldBe testCase.second
                }
            }
        }

        When("of(inputNumbers: String)에서 쉼표로 구분된 숫자가 아닌 값이 포함되면") {
            val inputNumbers = listOf(
                "1,2,+",
                "1,2,3, 4, 5, 1!",
                "123, -456"
            )
            Then("그 수들로 이루어진 LottoNumbers를 반환한다.") {
                inputNumbers.forAll { testCase ->
                    shouldThrow<IllegalArgumentException> {
                        LottoNumbers.of(testCase).numbers
                    }
                }
            }
        }
    }
})
