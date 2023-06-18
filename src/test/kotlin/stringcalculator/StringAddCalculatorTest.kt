package stringcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringAddCalculator() {
    fun add(text: String?): Int {
        return if (text.isNullOrEmpty()) 0 else text.toInt()
    }
}

class StringAddCalculatorTest : StringSpec({
    val calculator = StringAddCalculator()
    "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다." {
        calculator.add("") shouldBe 0
        calculator.add(null) shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        listOf("1", "2").forAll {
            calculator.add(it) shouldBe it.toInt()
        }
    }
})
