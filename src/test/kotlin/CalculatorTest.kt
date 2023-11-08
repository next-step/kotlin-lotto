import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "문자열 계산기는 숫자를 전달하면 합을 구한다." {
        Calculator().sum(listOf(1, 2, 3)) shouldBe 6
    }
})
