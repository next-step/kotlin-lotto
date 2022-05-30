package calculator.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class PositiveNumbersTest : FreeSpec({

    "주어진 정수의 총합을 반환한다." - {
        listOf(
            row(listOf(1, 2, 3, 4, 5), 15),
            row(listOf(1), 1),
            row(listOf(10, 20), 30),
        ).forEach { (numbers, result) ->
            "'$numbers'의 총합은 '$result'다." {
                val positiveNumbers = PositiveNumbers(numbers.map { PositiveNumber(it) })
                positiveNumbers.sum() shouldBe PositiveNumber(result)
            }
        }
    }
})
