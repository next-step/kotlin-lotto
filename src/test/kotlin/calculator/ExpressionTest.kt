package calculator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ExpressionTest : StringSpec({

    "주어진 문자열이 숫자인지 확인한다" {
        forAll(
            row("1", true),
            row("1,", false),
            row(":", false),
            row("//", false),
            row("\n", false)
        ) { text, expected ->
            Expression(text).isNumber() shouldBe expected
        }
    }

    "주어진 문자열을 숫자로 반환한다" {
        Expression("1").toPositiveInt() shouldBe 1
    }

    "숫자로만 이루어지지 않은 수식에 대해 숫자로 반환하려고 하면 예외가 발생한다." {
        shouldThrowWithMessage<RuntimeException>("숫자가 아닙니다.") { Expression("1,").toPositiveInt() }
    }

    "주어진 문자열이 음수면 예외가 발생한다." {
        shouldThrowWithMessage<RuntimeException>("음수는 입력할 수 없습니다.") { Expression("-1").toPositiveInt() }
    }

    "쉼표(,)와 콜론(:) 구분자를 가지고 있는 수식에 대해, 구분자를 기준으로 숫자를 분리한다." {
        forAll(
            row("1,2:3", listOf(1, 2, 3)),
            row("10:20,30", listOf(10, 20, 30))
        ) { text, expected ->
            Expression(text).split() shouldBe expected
        }
    }

    "쉼표(,)와 콜론(:) 구분자를 가지고 있는 수식에 대해, 구분자를 기준으로 분리 시 숫자가 아니면 예외가 발생한다." {
        forAll(
            row("1,2:$"),
            row("10:?,30"),
            row(":,")
        ) { text ->
            shouldThrowWithMessage<RuntimeException>("숫자가 아닙니다.") {
                Expression(text).split()
            }
        }
    }

    "쉼표(,)와 콜론(:) 구분자를 가지고 있는 수식에 대해, 구분자를 기준으로 분리 시 음수가 표함되어 있으면 예외가 발생한다." {
        forAll(
            row("1,-10:3"),
            row("-1:20,30")
        ) { text ->
            shouldThrowWithMessage<RuntimeException>("음수는 입력할 수 없습니다.") {
                Expression(text).split()
            }
        }
    }

    "문자열 첫부분에 입력된 //와 \n 문자 사이의 값을 커스텀 구분자로 지정하여, 구분자를 기준으로 숫자를 분리한다." {
        forAll(
            row("//;\n1;2;3", listOf(1, 2, 3)),
            row("//?\n10?20?30", listOf(10, 20, 30))
        ) { text, expected ->
            Expression(text).split() shouldBe expected
        }
    }

    "숫자 형태가 아니지만 쉼표(,)와 콜론(:) 구분자 없이, 커스텀 구분자도 존재하지 않으면 예외가 발생한다." {
        forAll(
            row("//;10;20;30"),
            row(";\n10;20")
        ) { text ->
            shouldThrowWithMessage<RuntimeException>("잘못된 수식입니다.") {
                Expression(text).split()
            }
        }
    }

    "정의된 커스텀 구분자가 외에 숫자가 아닌 다른 값이 들어오면 예외가 발생한다" {
        forAll(
            row("//;\n10?20;30")
        ) { text ->
            shouldThrowWithMessage<RuntimeException>("숫자가 아닙니다.") {
                Expression(text).split()
            }
        }
    }

    "정의된 커스텀 구분자가 외의 숫자가 음수면 예외가 발생한다." {
        forAll(
            row("//;\n10;-1;30")
        ) { text ->
            shouldThrowWithMessage<RuntimeException>("음수는 입력할 수 없습니다.") {
                Expression(text).split()
            }
        }
    }
})
