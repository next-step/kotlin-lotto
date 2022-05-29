package _string_add_calculator

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class StringAddCalculatorTest : ExpectSpec({
    context("add") {
        val calculator = StringAddCalculator()

        expect("빈 문자열 또는 null을 입력할 경우 0을 반환한다.") {
            forAll(
                row(null),
                row(""),
                row(" "),
            ) { text ->
                val result = calculator.add(text)

                result shouldBe 0
            }
        }

        expect("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환") {
            forAll(
                row("1", 1),
                row("2", 2),
                row("3", 3),
            ) {
                text, expect ->
                val result = calculator.add(text)

                result shouldBe expect
            }
        }

        expect("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
            forAll(
                row("1,2", 3),
                row("1,2,3", 6),
            ) {
                text, expect ->
                val result = calculator.add(text)

                result shouldBe expect
            }
        }

        expect("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.") {
            forAll(
                row("1:2", 3),
                row("1:2:3", 6),
                row("1,2:3", 6),
            ) {
                text, expect ->
                val result = calculator.add(text)

                result shouldBe expect
            }
        }

        expect("//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.") {
            forAll(
                row("//*\n1*2*3", 6),
                row("//^\n2^4^6", 12),
            ) {
                text, expect ->

                val result = calculator.add(text)

                result shouldBe expect
            }
        }
    }
})
