package stringCalculator

import io.kotest.core.spec.style.StringSpec
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
})
