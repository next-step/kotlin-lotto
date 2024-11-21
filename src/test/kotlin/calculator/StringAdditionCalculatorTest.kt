package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAdditionCalculatorTest : StringSpec({
    "빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다." {
        StringAdditionCalculator().add("") shouldBe 0
        StringAdditionCalculator().add(null) shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        StringAdditionCalculator().add("1") shouldBe 1
    }

    "숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        StringAdditionCalculator().add("1,2") shouldBe 3
        StringAdditionCalculator().add("2,3") shouldBe 5
    }

    "숫자 두개를 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        StringAdditionCalculator().add("1:2") shouldBe 3
        StringAdditionCalculator().add("2:3") shouldBe 5
    }

    "구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다." {
        StringAdditionCalculator().add("1,2:3") shouldBe 6
        StringAdditionCalculator().add("1:2,3") shouldBe 6
    }

    "\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        StringAdditionCalculator().add("//;\n1;2;3") shouldBe 6
        StringAdditionCalculator().add("//-\n1-2-3") shouldBe 6
    }

    "숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생해야 한다." {
        val exception =
            shouldThrow<RuntimeException> {
                StringAdditionCalculator().add("1,2,a")
            }
        exception.message shouldBe "숫자 이외의 값을 입력할 수 없습니다."
    }

    "음수를 전달할 경우 RuntimeException 예외가 발생해야 한다." {
        val exception =
            shouldThrow<RuntimeException> {
                StringAdditionCalculator().add("-1,2")
            }
        exception.message shouldBe "음수를 입력할 수 없습니다."
    }
})
