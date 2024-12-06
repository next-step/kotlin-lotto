package calculator.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AddCalculatorTest {
    @Test
    fun `더하기 입력 테스트`() {
        val calculator = AddCalculator()
        calculator.add(5).add(5).add(5)
        calculator.sumResult shouldBe 15
    }

    @Test
    fun `음수 입력 테스트`() {
        assertThrows<RuntimeException> { AddCalculator().add(-5) }
    }
}
