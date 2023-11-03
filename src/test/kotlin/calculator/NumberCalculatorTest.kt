package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberCalculatorTest : StringSpec({
    "음수가 아닌 숫자들이 들어오면 숫자들의 총 합을 반환한다." {
        forAll(
            row(listOf(1, 2, 3, 4), 10),
            row(listOf(1, 2, 3, 4, 5), 15),
            row(listOf(27, 23), 50),
            row(listOf(50, 20, 30), 100),
        ) { numbers: List<Int>, expect: Int ->
            NumberCalculator.sum(numbers) shouldBe expect
        }
    }
})
