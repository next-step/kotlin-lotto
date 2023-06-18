package stringcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringAddCalculator {
    private val delimiter = "[,:]".toRegex()
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) return 0
        if (text.contains(delimiter)) {
            return text.split(delimiter).sumOf { it.toInt() }
        }
        return text.toInt()
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
    "숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (예 : “1,2”)" {
        calculator.add("1,2") shouldBe 3
    }
})
