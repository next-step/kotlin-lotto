import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAdditionCalculator(private val str: String?) {
    fun add(): Int {
        if (str.isNullOrBlank()) return 0
        return str.toInt()
    }
}

class StringAdditionCalculatorTest : StringSpec({
    "빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다." {
        StringAdditionCalculator("").add() shouldBe 0
        StringAdditionCalculator(null).add() shouldBe 0
    }
})
