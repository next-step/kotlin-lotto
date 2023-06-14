package string

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import string.converter.ExpressionTokenConverter
import string.splitter.DefaultSeparatorStringSplitter
import string.splitter.RegexBasedCustomSeparatorStringSplitter
import string.splitter.SeparatorStringSplitter

internal class StringCalculatorTest : StringSpec({

    val tokenConverter = ExpressionTokenConverter()
    val splitters = listOf(
        RegexBasedCustomSeparatorStringSplitter(tokenConverter),
        DefaultSeparatorStringSplitter(tokenConverter)
    )
    val sut = StringCalculator(splitters)

    "빈 문자열을 입력하는 경우 0을 반환한다" {
        sut.sum("") shouldBe 0
    }

    "null 문자열을 입력하는 경우 0을 반환한다" {
        sut.sum("") shouldBe 0
    }

    "쉼표로 구분된 문자열을 덧셈한 결과를 반환한다" {
        sut.sum("1,2,3") shouldBe 6
    }

    "콜론으로 구분된 문자열을 덧셈한 결과를 반환한다" {
        sut.sum("1,2,3") shouldBe 6
    }

    "커스텀 구분자로 구분된 문자열을 덧셈한 결과를 반환한다" {
        table(
            headers("separator"),
            row(";"),
            row("-"),
            row("A"),
        ).forAll { separator ->
            sut.sum("//${separator}\n1${separator}2${separator}3") shouldBe 6
        }
    }

    "계산할 수 없는 형태의 식에 대해 예외가 발생한다" {
        shouldThrow<RuntimeException> {
            sut.sum("1k2k3")
        }
    }

})