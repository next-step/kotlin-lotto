package stringcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({

    it("숫자를 받고 총합 값을 내보낸다 ") {
        // given
        val numbers = listOf<Int>(1, 2, 3)
        val successTotalSum = 6

        // when
        val totalSum = Calculator.getTotalSum(numbers)

        // then
        successTotalSum shouldBe totalSum
    }
})
