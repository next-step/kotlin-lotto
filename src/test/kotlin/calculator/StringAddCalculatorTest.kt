package calculator

import calculator.StringAddCalculator.totalNumber
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("문자열 덧셈 계산기")
class StringAddCalculatorTest : StringSpec({

    "빈 문자열 또는 null 을 입력하면 0 반환" {
        listOf(null, "")
            .forAll {
                it.totalNumber shouldBe 0
            }
    }

    "숫자 하나를 문자열로 입력하면 해당 숫자로 반환" {
        listOf("1", "2", "3")
            .forAll {
                it.totalNumber shouldBe it.toInt()
            }
    }

    "숫자 두개를 쉼표(,) 구분자로 입력하면 두 숫자의 합을 반환" {
        listOf(
            "1,2" to 3,
            "1,3" to 4,
            "1,2,3,4" to 10,
        ).forAll {
            it.first.totalNumber shouldBe it.second
        }
    }

    "1,2,3 숫자를 커스텀 구분자로 숫자를 합하면 6" {
        listOf(
            "//;\n1;2;3",
            "//@\n1@2@3",
            "//#\n1#2#3",
        ).forAll {
            it.totalNumber shouldBe 6
        }
    }

    "음수를 전달할 경우 RuntimeException 예외 발생" {
        listOf(
            "-1,2,3",
            "1,-2,3",
            "1,2,-3",
        ).forAll {
            shouldThrow<RuntimeException> { it.totalNumber }
        }
    }
})
