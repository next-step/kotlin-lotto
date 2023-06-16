package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest: StringSpec({

    "계산기는 기본 구분자로 콤마(,)와 콜론(:)을 가진다." {
        // given
        val calculator = Calculator()

        // when & then
        calculator.DEFAULT_SEPARATORS[0] shouldBe ","
        calculator.DEFAULT_SEPARATORS[1] shouldBe ":"
    }

    "콤마(,)로 구분된 표현식이 주어졌을 때, 구분 되는 모든 숫자의 합을 반환 한다." {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.plusAll("1,2,3")

        result shouldBe 6
    }

    "콜론(:)으로 구분된 표현식이 주어졌을 때, 구분 되는 모든 숫자의 합을 반환 한다." {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.plusAll("1:2:3")

        result shouldBe 6
    }

    "사용자 지정 구분자가 포함된 표현식이 주어졌을 때, 구분 되는 모든 숫자의 합을 반환 한다." {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.plusAll("//;\n1;2;3")

        result shouldBe 6
    }

    "표현식을 구분자로 구분한 결과가 음수면 에러가 발생 한다." {
        // given
        val calculator = Calculator()

        // when & then
        shouldThrow<RuntimeException> { calculator.plusAll("1,2,-1") }
    }

    "표현식을 구분자로 구분한 결과가 숫자가 아니면 에러가 발생 한다." {
        // given
        val calculator = Calculator()

        // when & then
        shouldThrow<RuntimeException> { calculator.plusAll("1,2,-") }
    }
})
