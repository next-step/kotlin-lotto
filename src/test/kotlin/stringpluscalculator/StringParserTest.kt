package stringpluscalculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringParserTest : BehaviorSpec({

    Given("문자열 파서는") {
        When("구분자를 기준으로") {
            Then("문자를 분리하여 리스트를 반환한다.") {
                forAll(
                    row("1,2", listOf("1", "2")),
                    row("1,2,3", listOf("1", "2", "3"))
                ) { input, expected ->
                    StringParser.parser(input) shouldBe expected
                }
            }
        }
    }

    Given("문자열 파서의 구분자는") {
        When("쉼표(,) 또는 콜론(:) 구분자를 기준으로") {
            Then("문자를 분리하여 리스트를 반환한다.") {
                forAll(
                    row("1,2", listOf("1", "2")),
                    row("1,2:3", listOf("1", "2", "3"))
                ) { input, expected ->
                    StringParser.parser(input) shouldBe expected
                }
            }
        }
    }
})
