package string_calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class DelimitersTest : FunSpec({
    test("구분자로 숫자들을 구분한다.") {
        listOf(
            row(Delimiters(listOf(",", ":")), "1,2,3"),
            row(Delimiters(listOf(",", ":", ";")), "1,2;3"),
        ).forAll { (delimiters, expression) ->
            // when
            val actual = delimiters.split(expression)

            // then
            actual.size shouldBe 3
        }
    }
})
