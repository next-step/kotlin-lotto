package stringCalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({

    "빈 문자열을 입력하면 0을 반환한다." {
        val stringAddCalculator = StringAddCalculator()
        val expectedResult = 0
        val result = stringAddCalculator.sum("")
        result shouldBe expectedResult
    }

    "공백 문자열을 입력하면 0을 반환한다." {
        val stringAddCalculator = StringAddCalculator()
        val expectedResult = 0
        val result = stringAddCalculator.sum("   ")
        result shouldBe expectedResult
    }

    "null을 입력하면 0을 반환한다." {
        val stringAddCalculator = StringAddCalculator()
        val expectedResult = 0
        val result = stringAddCalculator.sum("   ")
        result shouldBe expectedResult
    }

    "숫자가 아닌 값를 입력하면 IllegalArgumentException이 발생한다." {
        val stringAddCalculator = StringAddCalculator()
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringAddCalculator.sum("1,!")
        }
        exception.message shouldBe "숫자가 아닌 값 혹은 음수를 입력하였습니다. (입력값:!)"
    }

    "음수를 입력하면 IllegalArgumentException이 발생한다." {
        val stringAddCalculator = StringAddCalculator()
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringAddCalculator.sum("1,-1")
        }
        exception.message shouldBe "숫자가 아닌 값 혹은 음수를 입력하였습니다. (입력값:-1)"
    }

    "숫자 더하기 테스트" {
        val stringAddCalculator = StringAddCalculator()
        forAll(
            row("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.", "1", 1),
            row("양수 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.", "+33", 33),
            row("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.", "1,2", 3),
            row("숫자 두개를 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다.", "1:2", 3),
            row("여러 숫자를 쉼표(,) 또는 콜론(:) 구분자로 섞어 경우 모든 숫자의 합을 반환한다.", "1:2,3", 6),
        ) { title, input, expectedOutput ->
            val actual = stringAddCalculator.sum(input)
            actual shouldBe expectedOutput
        }
    }

})
