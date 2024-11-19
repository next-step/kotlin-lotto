package calculator

import caculator.StringCalculator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    val calculator = StringCalculator()

    "문자열은 빈자열 또는 null일 경우 0을 반환한다." {
        calculator.add(null) shouldBe 0
        calculator.add("") shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        calculator.add("1") shouldBe 1
    }

    "숫자 두개를 컴마(,) 구분자로 입력할 경우 두숫자의 합을 반환한다." {
        calculator.add("1,2") shouldBe 3
    }

    "구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다." {
        calculator.add("1,2:3") shouldBe 6
    }

    "\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        calculator.add("//;\n1;2;3") shouldBe 6
    }
})
