package string

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table

internal class StringCalculatorTest : StringSpec({

    "쉼표로 구분된 문자열을 덧셈한 결과를 반환한다" {
        val sut = StringCalculator("1,2,3")
        sut.sum() shouldBe 6
    }

    "콜론으로 구분된 문자열을 덧셈한 결과를 반환한다" {
        val sut = StringCalculator("1,2,3")
        sut.sum() shouldBe 6
    }

    "커스텀 구분자로 구분된 문자열을 덧셈한 결과를 반환한다" {
        table(
            headers("separator"),
            row(";"),
            row("-"),
            row("A"),
        ).forAll { separator ->
            val sut = StringCalculator("//;\n1${separator}2${separator}3")
            sut.sum() shouldBe 6
        }
    }
})