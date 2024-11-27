package additioncalculator.domain

import additioncalculator.domain.Numbers
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun `입력 받은 숫자를 모두 합할 수 있다`() {
        val numbers = Numbers(numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        numbers.sum() shouldBe 55
    }
}
