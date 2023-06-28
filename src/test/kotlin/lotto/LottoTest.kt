package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber

internal class LottoTest : BehaviorSpec({

    Given("Lotto") {
        When("로또 번호가 6개가 아닐 경우") {
            val inputs = listOf(
                "1, 2, 3, 4, 5, 6, 7",
                "1, 2, 3, 4,5,6, 7, 8, 9",
                "1, 2, 3, 4, 5"
            )
            Then("해당 숫자들로 이루어진 Lotto 생성") {
                inputs.forAll { input ->
                    shouldThrow<IllegalArgumentException> { Lotto.of(input) }
                }
            }
        }

        When("of() 메서드에 쉼표를 구분자로 String이 주어졌을 때") {
            val expect = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
            val inputs = listOf(
                "1, 2, 3, 4, 5, 6" to expect,
                "1, 2, 3, 4,5,6" to expect,
                "1, 2, 3, 4, 5, 6" to expect
            )
            Then("해당 숫자들로 이루어진 Lotto 생성") {
                inputs.forAll { input ->
                    Lotto.of(input.first).lottoNumbers shouldBe input.second
                }
            }
        }
    }
})
