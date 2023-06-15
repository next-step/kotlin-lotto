package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class SeparatorKoTest : StringSpec({
    "문자열이 입력되면 특정 구분자를 통해 숫자들을 반환한다1" {
        io.kotest.data.forAll(
            table(
                headers("input", "expected"),
                row("1,2,3", listOf(1, 2, 3)),
                row("100,2,3", listOf(100, 2, 3)),
                row("1:2:3", listOf(1, 2, 3)),
                row("100:2:3", listOf(100, 2, 3)),
                row("10,2:145", listOf(10, 2, 145)),
                row("8:3,7", listOf(8, 3, 7)),
                row("", listOf(0)),
            ),
        ) { input: String, expected: List<Int> ->
            val result = Separator.extractIntegers(input)
            result shouldBe expected
        }
    }

    "문자열이 입력되면 특정 구분자를 통해 숫자들을 반환한다2" {
        listOf(
            "1,2,3" to listOf(1, 2, 3),
            "100,2,3" to listOf(100, 2, 3),
            "1:2:3" to listOf(1, 2, 3),
            "100:2:3" to listOf(100, 2, 3),
            "10,2:145" to listOf(10, 2, 145),
            "8:3,7" to listOf(8, 3, 7),
            "" to listOf(0),
        ).forAll { (input, expected) ->
            val result = Separator.extractIntegers(input)
            result shouldBe expected
        }
    }
})
