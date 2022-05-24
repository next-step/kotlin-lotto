package stringcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({

    it("숫자를 받고 총합 값을 내보낸다 ") {
        // given
        val numbers = listOf<Int>(1, 2, 3)

        // when
        val totalSum = Calculator.getTotal(numbers)

        // then
        val successTotalSum = 6
        successTotalSum shouldBe totalSum
    }
})
