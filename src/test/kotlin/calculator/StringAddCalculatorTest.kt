package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({

    "빈 문자열을 입력할 경우 0을 반환한다." {
        StringAddCalculator().add("") shouldBe 0
    }

    "null을 입력할 경우 0을 반환해야 한다." {
        StringAddCalculator().add(null) shouldBe 0
    }

    "음수를 입력한 경우 예외를 발생한다." {
        shouldThrow<RuntimeException> {
            StringAddCalculator().add("-1")
        }
    }

    "숫자 이외의 값을 입력한 경우 예외를 발생한다." {
        shouldThrow<RuntimeException> {
            StringAddCalculator().add("abc")
        }
    }

    "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        StringAddCalculator().add("1,2") shouldBe 3
    }

    "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다." {
        StringAddCalculator().add("1,2:3") shouldBe 6
    }

    "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        StringAddCalculator().add("//;\n1;2;3") shouldBe 6
    }
})
