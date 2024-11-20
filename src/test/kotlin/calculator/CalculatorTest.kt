package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({
    context("execute() 함수 테스트") {
        test("숫자와 구분자[콤마(,) 혹은 콜론(:)]로 구성된 문자열을 구분자를 기준으로 분리해서 합을 구한다.") {
            // given
            val testCases =
                table(
                    headers("input", "expected"),
                    row("1", 1),
                    row("1,2,3", 6),
                    row("1:2:3", 6),
                    row("1,2:3", 6),
                    row("1:2,3", 6),
                    row("1,2,3,4", 10),
                    row("1:2:3:4", 10),
                    row("1,2:3:4", 10),
                    row("1:2,3:4", 10),
                )

            // when
            forAll(testCases) { text, expected ->
                // then
                Calculator().execute(text) shouldBe expected
            }
        }
        test("기본 구분자 외에 커스텀 구분자를 지정할 수 있다.") {
            // given
            val testCases =
                table(
                    headers("input", "expected"),
                    row("//;\n1;2;3", 6),
                    row("//.\n1.2.3", 6),
                    row("//|\n1|2|3", 6),
                    row("//-\n1-2-3", 6),
                )

            // when
            forAll(testCases) { text, expected ->
                // then
                Calculator().execute(text) shouldBe expected
            }
        }
        test("빈문자열 또는 null을 입력할 경우 0을 반환해야 한다.") {
            // given
            val testCases =
                table(
                    headers("input", "expected"),
                    row("", 0),
                    row(null, 0),
                )

            // when
            forAll(testCases) { text, expected ->
                // then
                Calculator().execute(text) shouldBe expected
            }
        }

        test("문자열에 구분자가 연속해서 있는 경우 RuntimeException 예외를 발생시킨다.") {
            // given
            val testCases =
                table(
                    headers("input"),
                    row("1,,2,3"),
                    row("1::2,3"),
                    row("1,2::3"),
                    row("//-\n1--2-3"),
                )

            // when
            forAll(testCases) { text ->
                // then
                shouldThrow<RuntimeException> {
                    Calculator().execute(text)
                }
            }
        }

        test("문자열 계산기에 숫자 이외의 값이 전달되면 RuntimeException 예외를 발생시킨다.") {
            // given
            val testCases =
                table(
                    headers("input"),
                    row("1,2,3,a"),
                    row("1:2:3:b"),
                    row("1,2:3:c"),
                    row("//|\n1|2|3|d"),
                )

            // when
            forAll(testCases) { text ->
                // then
                shouldThrow<RuntimeException> {
                    Calculator().execute(text)
                }
            }
        }

        test("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 발생시킨다.") {
            // given
            val testCases =
                table(
                    headers("input"),
                    row("-1,2,3"),
                    row("1:-2:3"),
                    row("1,2:-3"),
                    row("//|\n1|2|-3"),
                )

            // when
            forAll(testCases) { text ->
                // then
                shouldThrow<RuntimeException> {
                    Calculator().execute(text)
                }
            }
        }
    }
})
