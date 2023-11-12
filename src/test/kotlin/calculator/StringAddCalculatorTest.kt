package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({

    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다." {
        forAll(
            row(""),
            row("  "),
            row(null)
        ) { text ->
            StringAddCalculator.add(text) shouldBe 0
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        forAll(
            row("1", 1),
            row("100", 100)
        ) { text, expected ->
            StringAddCalculator.add(text) shouldBe expected
        }
    }

    "숫자 두 개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        forAll(
            row("1,2", 3),
            row("10,20", 30)
        ) { text, expected ->
            StringAddCalculator.add(text) shouldBe expected
        }
    }

    "숫자 두 개를 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        forAll(
            row("1:2", 3),
            row("10:20", 30)
        ) { text, expected ->
            StringAddCalculator.add(text) shouldBe expected
        }
    }

    "쉼표(,)와 콜론(:) 구분자를 혼용하여 입력할 수 있다." {
        forAll(
            row("1,2:3", 6),
            row("10:20,30", 60)
        ) { text, expected ->
            StringAddCalculator.add(text) shouldBe expected
        }
    }

    "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다." {
        forAll(
            row("-1"),
            row("10:-1"),
            row("10,-10"),
            row("10:20,-30")
        ) { text ->
            shouldThrow<RuntimeException> { StringAddCalculator.add(text) }
        }
    }

    "//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        forAll(
            row("//;\n1;2;3", 6),
            row("//?\n10?20?30", 60)
        ) { text, expected ->
            StringAddCalculator.add(text) shouldBe expected
        }
    }
})
