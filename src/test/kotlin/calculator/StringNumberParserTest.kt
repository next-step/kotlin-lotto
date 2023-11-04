package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.RuntimeException

class StringNumberParserTest : FunSpec({
    val stringNumberParser = StringNumberParser()

    context("문자열 표현식 내 숫자 추출 동작 테스트") {
        test("null, 공백, 빈 문자열을 전달할 경우 0 하나만 포함한 리스트 반환") {
            forAll(
                row(null),
                row(""),
                row(" ")
            ) { input ->
                val result = stringNumberParser.getNumbers(input)

                result shouldBe listOf(0)
            }
        }

        test("숫자가 1개만 포함된 표현식의 경우 해당 숫자만 포함하는 리스트 반환") {
            val input = "1"

            val result = stringNumberParser.getNumbers(input)

            result shouldBe listOf(1)
        }

        test("2개 이상의 숫자가 포함된 표현식의 경우 일치하는 숫자 모두 리스트로 반환") {
            val input = "1,2"

            val result = stringNumberParser.getNumbers(input)

            result shouldBe listOf(1, 2)
        }
    }

    context("문자열 표현식 내 구분자에 따른 동작 테스트") {
        test("기본 구분자로만 이루어진 표현식의 정상 반환") {
            forAll(
                row("1,2", listOf(1, 2)),
                row("1:2", listOf(1, 2)),
                row("1,2,3", listOf(1, 2, 3)),
                row("1:2:3", listOf(1, 2, 3)),
                row("1,2:3", listOf(1, 2, 3))
            ) { input, answer ->
                val result = stringNumberParser.getNumbers(input)

                result shouldBe answer
            }
        }

        test("커스텀 구분자가 포함된 표현식의 정상 반환") {
            forAll(
                row("//!\\n", listOf(0)),
                row("//!\\n1", listOf(1)),
                row("//!\\n1!2", listOf(1, 2)),
                row("//!\\n1!2,3", listOf(1, 2, 3)),
                row("//!\\n1!2:3", listOf(1, 2, 3)),
                row("//!\\n1,2:3", listOf(1, 2, 3)),
            ) { input, answer ->
                val result = stringNumberParser.getNumbers(input)

                result shouldBe answer
            }
        }
    }

    context("문자열 표현식 분석기 예외 테스트") {
        test("표현식 형식이 잘못 입력된 경우 RuntimeException") {
            forAll(
                row(","),
                row("1,"),
                row(",1"),
                row("//!\\n,"),
                row("//!\\n1,"),
                row("//!\\n,1"),
                row("//\\n"),
                row("//\\n,"),
                row("//\\n1,"),
                row("//\\n,1"),
            ) { input ->
                shouldThrow<RuntimeException> {
                    stringNumberParser.getNumbers(input)
                }
            }
        }

        test("잘못된 숫자가 입력된 경우 RuntimeException") {
            forAll(
                row("-1"),
                row("a"),
                row("a,-1"),
                row("//!\\n-1"),
                row("//!\\na"),
                row("//!\\na,-1"),
            ) { input ->
                shouldThrow<RuntimeException> {
                    stringNumberParser.getNumbers(input)
                }
            }
        }

        test("기본 또는 커스텀 구분자가 아닌 구분자가 입력된 경우 RuntimeException") {
            forAll(
                row("1?2"),
                row("//!\\n1?2"),
            ) { input ->
                shouldThrow<RuntimeException> {
                    stringNumberParser.getNumbers(input)
                }
            }
        }
    }
})
