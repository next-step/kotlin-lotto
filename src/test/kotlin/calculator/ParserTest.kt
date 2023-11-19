package calculator

import caclulator.Parser
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.Row2
import io.kotest.data.forAll
import io.kotest.matchers.shouldBe

class ParserTest: StringSpec({

    "계산식 파싱(커스텀, 일반, 빈값)을 진행해야 한다" {
        forAll(
            Row2("//;\\n1;2;3", listOf(1, 2, 3)),
            Row2("1:2,3", listOf(1, 2, 3)),
            Row2("", emptyList()),
            Row2(null, emptyList())
        ) { input, expected ->
            val result = Parser.parse(input)
            result shouldBe expected
        }
    }
})