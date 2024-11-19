import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAdditionCalculator(private val str: String?) {
    fun add(): Int {
        if (str.isNullOrBlank()) return 0

        val numbers = str.split(",").map { it.split(":") }.flatten()
        if (numbers.size == 1) {
            return str.toInt()
        }

        return numbers.map { it.toInt() }.sum()
    }
}

class StringAdditionCalculatorTest : StringSpec ({
    "빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다." {
        StringAdditionCalculator("").add() shouldBe 0
        StringAdditionCalculator(null).add() shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        StringAdditionCalculator("1").add() shouldBe 1
    }

    "숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        StringAdditionCalculator("1,2").add() shouldBe 3
        StringAdditionCalculator("2,3").add() shouldBe 5
    }

    "숫자 두개를 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        StringAdditionCalculator("1:2").add() shouldBe 3
        StringAdditionCalculator("2:3").add() shouldBe 5
    }
})