package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class ParserTest : StringSpec({
    "문자열을 숫자 리스트로 반환한다" {
        table(
            headers("text", "expected"),
            row("//;\n1;2;3;4", listOf(1, 2, 3, 4)),
            row("//.\n1.2.3.4", listOf(1, 2, 3, 4)),
            row("//^\n1:2^3,4", listOf(1, 2, 3, 4)),
            row("//%\n1:2%3%4", listOf(1, 2, 3, 4)),
        ).forAll { text, expected ->
            Parser.parseToNumbers(text) shouldBe expected
        }
    }
})
