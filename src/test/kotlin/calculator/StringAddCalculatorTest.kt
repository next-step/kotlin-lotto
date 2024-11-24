package calculator

import calculator.StringAddCalculator.add
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.awt.SystemColor.text

class StringAddCalculatorTest : StringSpec({
    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다" {
        listOf(null, "").forAll { text ->
            add(text) shouldBe 0
        }
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" {
        add("1") shouldBe 1
    }

    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다" {
        add("1,2") shouldBe 3
    }

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다" {
        add("1,2:3") shouldBe 6
    }

    """//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다""" {
        table(
            headers("text", "expected"),
            row("//;\n1;2;3", 6),
            row("//.\n1.2.3", 6),
            row("//^\n1:2^3", 6),
            row("//%\n1:2,3%4", 10),
        ).forAll { text, expected ->
            add(text) shouldBe expected
        }
    }

    "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 발생한다" {
        shouldThrow<RuntimeException> { add("-1") }
    }

    "숫자가 아닌 글자를 입력하는 경우 RuntimeException 예외 발생한다" {
        shouldThrow<RuntimeException> { add("1,a,b") }
    }
})
