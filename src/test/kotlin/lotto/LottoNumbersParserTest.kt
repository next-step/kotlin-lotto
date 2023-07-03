package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.view.LottoNumberParser

internal class LottoNumbersParserTest : BehaviorSpec({

    Given("LottoNumbersParser") {
        val lottoNumbersParser = LottoNumberParser
        When("white space가 섞인 번호가 입력되면") {
            val expect = listOf(1, 2, 3)
            val inputs = listOf(
                "1,2,3" to expect,
                "1, 2, 3" to expect,
                "1, 2,3" to expect
            )
            Then("올바르게 List<Int>로 파싱된다.") {
                inputs.forAll { input ->
                    val actual = lottoNumbersParser.splitInputLottoNumbers(input.first)
                    actual shouldBe input.second
                }
            }
        }

        When("validateLottoNumber() 메서드에 숫자가 아닌 값이 입력되면") {
            val inputs = listOf(
                "+",
                "1,",
                "12~"
            )
            Then("IllegalArgumentException 발생") {
                inputs.forAll { input ->
                    shouldThrow<IllegalArgumentException> { lottoNumbersParser.validateLottoNumber(input) }
                }
            }
        }
    }
})
