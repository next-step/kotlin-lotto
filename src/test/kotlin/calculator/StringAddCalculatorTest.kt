package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({

    "공백 문자열에나 null 입력할 때 0을 반환" {
        forAll(
            row(null),
            row(""),
            row(" "),
        ) {
            StringAddCalculator.add(it) shouldBe 0
        }
    }

    "숫자 하나를 문자열로 입력할 때 해당 숫자를 반환" {
        StringAddCalculator.add("1") shouldBe 1
    }

    "숫자 두개를 컴마 구분자로 입력할 때 숫자의 합을 반환" {
        StringAddCalculator.add("1,2") shouldBe 3
    }

    "구분자는 컴마(,)와 콜론(:) 사용 가능" {
        StringAddCalculator.add("1,2:3") shouldBe 6
    }

    "//와 \n 문자 사이에 커스텀 구분자 지정 가능" {
        StringAddCalculator.add("//;\n1;2;3") shouldBe 6
    }

    "음수를 전달할 때 예외 발생" {
        val exception = shouldThrow<IllegalArgumentException> {
            StringAddCalculator.add("-1,2,3")
        }
        exception.message shouldBe "음수는 입력할 수 없습니다."
    }
})
